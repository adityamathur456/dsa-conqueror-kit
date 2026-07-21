class Solution {
    public String simplifyPath(String path) {
        Stack<String> stackPath = new Stack<>();
        String[] paths = path.split("/");

        for (String cur : paths) {
            if (cur.equals("..")) {
                if (!stackPath.isEmpty()) stackPath.pop();
            } else if (!cur.equals("") && !cur.equals(".")) {
                stackPath.push(cur);
            } 
        }

        return "/" + String.join("/", stackPath);
    }
}