import java.util.Scanner;

public class vivaQ6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        String[] str=new String[T];

        for(int i=0;i<T;i++){
            boolean done=false;
            while(done==false){

                boolean low=false;
                while(!low){
                    str[i]=sc.next();
                    low=true;

                    if (str[i].length()>50) {  
                        low=false;
                        continue;
                    }

                    for (int j=0;j<str[i].length();j++){
                        char c = str[i].charAt(j);
                        if (!((c>='a' && c<='z') || (c>='0' && c<='9'))) {
                            low=false;
                            break;
                        }
                    }
                }

                int length=0;
                boolean good=true;

                if(str[i].isEmpty()||Character.isDigit(str[i].charAt(0))){
                    good=false;
                }

                if(good==true){
                    for(int j=0;j<str[i].length();j++){

                        if(Character.isLetter(str[i].charAt(j))){
                            length=length+1;
                        }
                        else if(Character.isDigit(str[i].charAt(j))){

                            if(str[i].charAt(j)=='0'||str[i].charAt(j)=='1'){
                                good=false;
                                break;
                            }

                            if(j==0||Character.isDigit(str[i].charAt(j-1))){
                                good=false;
                                break;
                            }

                            length+=(str[i].charAt(j)-'0')-1;
                        }
                        else{
                            good=false;
                            break;
                        }
                    }
                }

                if(good&&length>200){
                    continue;
                }

                if(good && length<=200){
                    System.out.print(length+ " ");
                    done=true;
                } 
                else if(!good){
                    System.out.print("Invalid Log ");
                    done=true;
                }
            }
        }
    }
}
