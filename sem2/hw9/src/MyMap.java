import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class MyMap<K extends Comparable<K>,V> implements Map<K,V> {

    private Tree<K,V> root;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Tree<K extends Comparable<K>,V> {
        private Tree<K,V> parent;
        private Tree<K,V> left;
        private Tree<K,V> right;
        private K key;
        private V value;

        public Tree(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Tree<K,V> get(K key) {
            int cmp = key.compareTo(this.key);
            if (cmp == 0) {
                return this;
            } else if (cmp < 0 && left != null) {
                return left.get(key);
            } else if (cmp > 0 && right != null) {
                return right.get(key);
            } else {
                return null;
            }
        }

        public K remove(K key) {
            Tree<K,V> node = get(key);
            if (node == null) {
                return null;
            } else {
                K result = node.key;
                if (node.left == null && node.right == null) {
                    if (node.parent != null) {
                        if (node.parent.left == node) {
                            node.parent.left = null;
                        } else {
                            node.parent.right = null;
                        }
                    }
                } else if (node.left == null) {
                    node.right.parent = node.parent;
                    if (node.parent != null) {
                        if (node.parent.left == node) {
                            node.parent.left = node.right;
                        } else {
                            node.parent.right = node.right;
                        }
                    } else {
                        node.right.parent = null;
                    }
                } else if (node.right == null) {
                    node.left.parent = node.parent;
                    if (node.parent != null) {
                        if (node.parent.left == node) {
                            node.parent.left = node.left;
                        } else {
                            node.parent.right = node.left;
                        }
                    } else {
                        node.left.parent = null;
                    }
                } else {
                    Tree<K,V> successor = node.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                    node.key = successor.key;
                    node.value = successor.value;
                    successor.remove(successor.key);
                }
                return result;
            }
        }

        public V add(Tree<K,V> node) {
            if (node.key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }
            int cmp = node.key.compareTo(key);
            if (cmp == 0) {
                V oldValue = value;
                value = node.value;
                return oldValue;
            } else if (cmp < 0) {
                if (left == null) {
                    left = node;
                    left.parent = this;
                    return null;
                } else {
                    return left.add(node);
                }
            } else {
                if (right == null) {
                    right = node;
                    right.parent = this;
                    return null;
                } else {
                    return right.add(node);
                }
            }
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public int size() {
        if (root == null){
            return 0;
        }

        Queue<Tree<K,V>> queue = new ArrayDeque<>();
        int size = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            Tree<K,V> tree = queue.remove();

            if (tree.getLeft()!= null) {
                queue.add(tree.getLeft());
            }
            if (tree.getRight()!= null) {
                queue.add(tree.getRight());
            }
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (root == null || key == null || !(key instanceof Comparable)) {
            return false;
        }
        Tree<K,V> node = root.get((K) key);
        return (node != null);
    }

    @Override
    public boolean containsValue(Object value) {
        if (root == null || value == null) {
            return false;
        }
        Queue<Tree<K,V>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Tree<K,V> tree = queue.remove();
            if (tree.getValue().equals(value)) {
                return true;
            }
            if (tree.getLeft()!= null) {
                queue.add(tree.getLeft());
            }
            if (tree.getRight()!= null) {
                queue.add(tree.getRight());
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (root == null || key == null || !(key instanceof Comparable)) {
            return null;
        }
        Tree<K,V> node = root.get((K) key);
        return (node == null) ? null : node.getValue();
    }

    @Override
    public V put(K key, V value) {
        if (root == null) {
            root = new Tree<>(key, value);
            return null;
        }
        Tree<K,V> node = root.get(key);
        if (node != null) {
            V oldValue = node.getValue();
            node.setValue(value);
            return oldValue;
        } else {
            node = new Tree<>(key, value);
            return root.add(node);
        }
    }

    @Override
    public V remove(Object key) {
        if (root == null || key == null || !(key instanceof Comparable)) {
            return null;
        }
        K k = (K) key;
        Tree<K,V> node = root.get(k);
        if (node == null) {
            return null;
        }
        V oldValue = node.getValue();
        K deletedKey = node.remove(k);
        if (deletedKey == null) {
            return null;
        }
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<K> keySet() {
        if (root == null) {
            return new HashSet<>();
        } else {
            Set<K> set = new HashSet<>();
            Queue<Tree<K,V>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Tree<K,V> tree = queue.remove();
                set.add(tree.getKey());
                if (tree.getLeft() != null) {
                    queue.add(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    queue.add(tree.getRight());
                }
            }
            return set;
        }
    }

    @Override
    public Collection<V> values() {
        if (root == null) {
            return new ArrayList<>();
        } else {
            List<V> list = new ArrayList<>();
            Queue<Tree<K,V>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Tree<K,V> tree = queue.remove();
                list.add(tree.getValue());
                if (tree.getLeft() != null) {
                    queue.add(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    queue.add(tree.getRight());
                }
            }
            return list;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        addEntries(root, entries);
        return entries;
    }

    private void addEntries(Tree<K, V> node, Set<Entry<K, V>> entries) {
        if (node == null) {
            return;
        }
        entries.add(new AbstractMap.SimpleEntry<>(node.getKey(), node.getValue()));
        addEntries(node.getLeft(), entries);
        addEntries(node.getRight(), entries);
    }
}