/**
 * 1452. 收藏清单
 */

package LeetcodeJava.Sorting;

import java.text.CollationElementIterator;
import java.util.*;

public class PeopleIndexes {
    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}
                     , {2, 2, 1, 2}
                     , {1, 1, 1, 2}};
        String[][] favoriteCompanies = {{"leetcode","google","facebook"},
                                        {"google","microsoft"},
                                        {"google","facebook"},
                                        {"google"},
                                        {"amazon"}};
//        String[][] favoriteCompanies = {{"leetcode"},{"google"},
//                {"amazon"},
//                {"facebook"}};
        List<List<String>> input = new ArrayList<>();
        for(String[] strs :favoriteCompanies){
            input.add(Arrays.asList(strs));
//            System.out.println(input.get(input.size()-1));
        }
        PeopleIndexes obj = new PeopleIndexes();
        List<Integer> solution = obj.peopleIndexes(input);
        System.out.println(solution);
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        //用一个MAP存放 清单长度:清单下标
        Map<Integer,List<Integer>> level = new HashMap<>();
        for(int i =0;i<favoriteCompanies.size();i++){
            int listLength = favoriteCompanies.get(i).size();
//            if(level.get(listLength)==null) level.put(listLength,new ArrayList<>());
            level.computeIfAbsent(listLength, k -> new ArrayList<>());
            level.get(listLength).add(i);
        }
        //将MAP的key按顺序排列
        Object[] sortedLevelIndex =  level.keySet().toArray();
        Arrays.sort(sortedLevelIndex);


        //已加入ans的每个清单的公司集合
        List<Set<String>> companySetList = new ArrayList<>();

        //数组的第一个就是长度的那些最大清单的下标，将他们都加入ans中
        for(Integer ind:level.get(sortedLevelIndex[sortedLevelIndex.length-1])){
            ans.add(ind);
            companySetList.add(new HashSet(favoriteCompanies.get(ind)));
        }


        //依次判断剩下的清单是否包含在ans里的清单中
        for(int i=sortedLevelIndex.length-2;i>=0;i--){
            //取得上一长度的companySetList
            List<Set<String>> lastCompanySetList = new ArrayList<>(companySetList);

            //取得这一长度所有清单下标
            for(Integer ind :level.get(sortedLevelIndex[i])){
                int pass = 0;
                //取得 companySetList 里每个清单的 公司集合
                for(Set set:lastCompanySetList){
//                    for(String company : favoriteCompanies.get(ind)){
//                        if(!set.contains(company)){
////                            System.out.println(set.toString()+" contains "+company);
//                            pass++;
//                            break;
//                        }
//                    }
                    if(!set.containsAll(favoriteCompanies.get(ind))){
                        pass++;
                    }
                }
                if(pass==lastCompanySetList.size()){
                    ans.add(ind);
                    companySetList.add(new HashSet(favoriteCompanies.get(ind)));
                }
            }

        }

        Collections.sort(ans);
        return ans;
    }

}
