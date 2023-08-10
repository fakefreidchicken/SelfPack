package com.syx.tree;

import java.util.*;

/**
 * ClassName: HuffmanCode <br/>
 * Description: <br/>
 * date: 2023/8/10 15:33 <br/>
 *
 * @author Mr.Shen <b/r>
 * @since JDK 8
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        byte[] huffmanCodesBytes= huffmanZip(contentBytes);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);
    }
    /**
     *
     * @param bytes
     * @return 经过huffman编码处理后的字节数组(压缩后的数组)
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<HuffmanNode> huffmanNodes = getHuffmanNodes(bytes);
        HuffmanNode huffmanTreeRoot = createHuffmanTree(huffmanNodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
    /**
     * 将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
     * @param bytes
     * @param huffmanCodes
     * @return
     */
    private static byte[] zip(byte[] bytes ,Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if(stringBuilder.length()%8 == 0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8 + 1;
        }
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for(int i=0;i < stringBuilder.length();i+=8){
            String strByte;
            if(i+8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }

    /**
     * 生成赫夫曼树对应的赫夫曼编码
     * 将赫夫曼编码表存放在 Map<Byte,String> 形式
     * 生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
     * 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
     */
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * 接收byte的字节数组
     *
     * @param bytes
     * @return 返回HuffmanNode的list，完成词频统计
     */
    private static List<HuffmanNode> getHuffmanNodes(byte[] bytes) {
        ArrayList<HuffmanNode> huffmanNodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            huffmanNodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return huffmanNodes;
    }

    /**
     * 通过传入的List创建对应的HuffmanTree
     *
     * @param nodes
     * @return HuffmanTree的根节点
     */
    private static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanNode node1 = nodes.get(0);
            HuffmanNode node2 = nodes.get(1);
            HuffmanNode newNode = new HuffmanNode(null, node1.weight + node2.weight);
            newNode.left = node1;
            newNode.right = node2;
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    private static void preOrder(HuffmanNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("哈夫曼树为空");
        }
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    /**
     * data 存放数据(字符)本身，比如'a' => 97 ' ' => 32
     * weight 权值, 表示字符出现的次数
     */
    Byte data;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            this.left.preOrder();
        }
        if (right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
