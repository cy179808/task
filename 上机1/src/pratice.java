import java.io.*;

public class pratice {
    private static  final String FilePath="D:\\JAVA\\src\\作业2.java";
    private static  final String FilePath1="D:\\JAVA\\src\\作业21.java";
    public static void main(String[] args)throws IOException {
        File file=new File(FilePath);
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes=new byte[(int)file.length()];
        inputStream.read(bytes);
        String content=new String(bytes);
        //System.out.println(content);
        OutputStream outputStream=new FileOutputStream(FilePath1);
        outputStream.write(content.getBytes());
        outputStream.close();
    }
}
