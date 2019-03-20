package Test;

import java.util.*;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode cur = dummy;
      int carry = 0;
      while (l1!=null||l2!=null){
          int d1=l1==null?0:l1.val;
          int d2=l2==null?0:l2.val;
          int sum=d1+d2+carry;
          carry=sum>10?1:0;
          cur.next=new ListNode(sum%10);
          cur=cur.next;
          if(l1!=null)l1=l1.next;
          if(l2!=null){
              l2=l2.next;
          }
      }
      if(carry==1){
          cur.next=new ListNode(1);
      }
      return dummy.next;
    }

    //left：左边界，i作为右边界，数组m作为字典存储最后出现的索引
    //
    //从左往右遍历，如果出现重复的字符，则回到重复的左边界
    public int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m,-1);
        int left=-1,res=0;
        for (int i = 0; i <s.length() ; i++) {
            left=Math.max(left,m[s.charAt(i)]);
            m[s.charAt(i)]=i;
            res=Math.max(res,i-left);//宽度比较，更新最大边界
        }
        return res;
    }

    public static void main(String [] args){
       System.out.print(new Solution().findMedianSortedArrays(new int[]{1, 2},new int[]{3, 4}));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       /* int n=nums1.length,m=nums2.length;
        int median=0;
        if(n>0 && m>0){
            int [] array=new int[n+m];
            int noffset=0,moffset=0;
            for (int i = 0; i < array.length; i++) {
                if(i+1<Math.min(m,n)){
                    if(nums1[noffset]<nums2[moffset]){
                        array[i]=nums1[noffset++];
                    }else{
                        array[i]=nums2[moffset++];
                    }
                }else {
                    if(n-noffset<m-moffset){
                        array[i]=nums2[moffset++];
                    }else {
                        array[i]=nums1[noffset++];
                    }
                }

            }

            if((n+m)%2==0){
                median=(array[(n+m)/2-1]+array[(n+m)/2])/2;
            }else {
                median=array[(n+m+1)/2-1];
            }
        }
        return median;*/

     /*  if(nums1.length==0&&nums2.length==0){
           return 0;
       }

        int [] array=new int[nums1.length+nums2.length];
        int n=0,m=0;

        for (int i = 0; i < array.length; i++) {
            if(n>=nums1.length&&m<nums2.length){
                array[i]=nums2[m];
                m++;
            }else
            if(m>=nums2.length&&n<nums1.length){
                array[i]=nums1[n];
                n++;
            }else {
                if(nums1[n]<nums2[m]){
                    array[i]=nums1[n];
                    n++;
                }else {
                    array[i]=nums2[m];
                    m++;
                }
            }
        }

        double median=0;

        if((nums1.length+nums2.length)%2==0){
            median=(double)(array[(nums1.length+nums2.length)/2-1]+array[(nums1.length+nums2.length)/2])/2.0;
        }else {
            median=array[(nums1.length+nums2.length+1)/2-1];
        }
        return median;*/

        int m=nums1.length,n=nums2.length;
        if(m>n){
            int [] temp=nums1;
            nums1=nums2;
            nums2=temp;
            m=nums1.length;
            n=nums2.length;
        }
        int imin=0,imax=m,halfLength=(m+n+1)/2;
        while (imin<=imax){
            int i=(imin+imax)/2;
            int j = halfLength-i;
            if(i<imax&&nums1[i]<nums2[j-1]){
                imin=i+1;
            }else if(i>imin&&nums1[i-1]>nums2[j]) {
                imax=i-1;
            }else {
                int maxLeft=0;
                if(i==0){
                    maxLeft=nums2[j-1];
                }else if(j==0){
                    maxLeft=nums1[i-1];
                }else {
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==1){
                    return maxLeft;
                }
                int minRight=0;
                if(i==m){
                    minRight=nums2[j];
                }else if(j==n){
                    minRight=nums1[i];
                }else {
                    minRight=Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

}
