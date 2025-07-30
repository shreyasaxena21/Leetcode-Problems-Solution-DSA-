class Solution {
    public String simplifyPath(String path) {
        // step 1 is to split the string on the basis of /
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String currentPath : paths){
            if(currentPath.equals(".") || currentPath.trim().length()==0){
                continue; // skip the current iteration
            }

            else if(currentPath.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop(); // parent directory
                }
            }

            else{
                stack.push(currentPath);
            }
        }

        // stringbuilder to store and add canonical paths
        StringBuilder canonicalPath = new StringBuilder();
        for(String cpath : stack){
            canonicalPath.append("/");
            canonicalPath.append(cpath);
        }

        return canonicalPath.toString().length()>0 ? canonicalPath.toString() : "/";
    }
}