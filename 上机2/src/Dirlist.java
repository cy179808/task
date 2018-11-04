import java.util.*;
import java.io.*;
import java.util.regex.*;
/*public class Dirlist {
    public static void main(final String[] args){
        File path=new File(".");
        String[] list;
        if(args.length==0)
            list=path.list();
        else
            list=path.list(new FilenameFilter() {
                private Pattern pattern=Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:list)
            System.out.println((dirItem));
    }
}*/
public class Dirlist{
    public static  String read(String filename) throws IOException{
        BufferedReader in=new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb=new StringBuilder();
        while((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return sb.toString();
    }
    public static void main(String[] args)
        throws IOException{
        System.out.print(read("library.bib"));
    }
}
