package lc.sort;

/**
 * @author enyi.lr
 * @version $Id: S_937_ReorderDatainLogFiles.java, v 0.1 2019‐12‐14 8:42 PM enyi.lr Exp $$
 */
public class S_937_ReorderDatainLogFiles {
    public static void main(String[] args) {
        S_937_ReorderDatainLogFiles logFiles = new S_937_ReorderDatainLogFiles();
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        String[] strings = logFiles.reorderLogFiles(logs);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    // todo need to fix bug
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        int k = 0;
        // use selection sort to solve the problem
        for(int i = 0; i < logs.length; i++){
            String log = logs[i];
            if(isLetterLogs(log)){
                result[k] = log;
                k++;
            }
        }
        for(int i = 0; i < k; i++){
            // sort select the minimum alpha
            int min_idx = i;
            String[] string1 = result[i].split(" ");
            for (int j = i+1; j < k; j++){
                String[] string2 = result[j].split(" ");
                if(result[j].substring(string2[0].length()).compareTo(result[i].substring(string1[0].length())) < 0){
                    min_idx = j;
                } else if(result[j].substring(string2[1].length()).compareTo(result[i].substring(string1[1].length())) == 0) {
                    if(result[j].compareTo(result[i]) < 0){
                        min_idx = j;
                    }
                }
            }
            if(i != min_idx){
                swap(result,i,min_idx);
            }

        }
        for(int i = 0; i < logs.length; i++){
            String log = logs[i];
            if(!isLetterLogs(log)){
                result[k] = log;
                k++;
            }
        }
        return result;
    }

    private void swap(String[] arr, int i,int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isLetterLogs(String log){
        String[] words = log.split(" ");
        char[] chars = words[1].toCharArray();
        return Character.isLetter(chars[0]);
    }

}