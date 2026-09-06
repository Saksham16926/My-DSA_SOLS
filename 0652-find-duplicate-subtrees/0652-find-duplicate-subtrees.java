class Solution {
    private Map<String, Integer> countMap = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String leftSerial = serialize(node.left);
        String rightSerial = serialize(node.right);

        String serial = node.val + "," + leftSerial + "," + rightSerial;
        countMap.put(serial, countMap.getOrDefault(serial, 0) + 1);

        if (countMap.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }
}