package offer;

/**
 * @author： xiaoxiao
 * @date: 2017/12/5 20:44
 * 判断是否为平衡搜索树的后序遍历
 */
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int [] sequence,int l,int h){
        if(l==h){
            return true;
        }
        int m=h-1;
        if(l>h){
            return true;
        }
        while(sequence[m]>sequence[h]) {
            m--;
            if (m < 0) {
                break;
            }

        }
        for (int i=l;i<m;i++){
            if (sequence[i]>sequence[h]){
                return false;
            }
        }

        return judge(sequence,l,m)&&judge(sequence,m+1,h-1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST=new VerifySquenceOfBST();
        int a[]={7,4,6,5};
        System.out.println(verifySquenceOfBST.verifySquenceOfBST(a));

    }
}
