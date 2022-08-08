package proskyspringskyprohw214;

import java.util.Arrays;

public class ListImpl implements StringList {

    private String[] list;

    public ListImpl(String[] list) {
        this.list = list;
    }


    @Override
    public String add(String item) {
        String[] listCopy;
        if (item == null) {
            throw new ListIndexException();
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = item;
                    break;
                } else {
                    listCopy = Arrays.copyOf(list, list.length + 1);
                    listCopy[list.length] = item;
                }
            }
            return item;
        }
    }

    @Override
    public String add(int index, String item) {
        String[] listCopy = new String[list.length + 1];
        if (index > list.length - 1 || item == null) {
            throw new ListIndexException();
        } else
            for (int i = 0; i < index + 1; i++) {
                list[index] = item;
                listCopy[i] = list[i];
                for (int j = index + 1; j < list.length; j++) {
                    listCopy[j] = list[j - 1];
                }
            }
        return listCopy[index];
    }

    @Override
    public String set(int index, String item) {
        int count = 0;
        String[] listCopy = new String[list.length - 1];
        for (int n = 0; n < list.length; n++) {
            if (list != null) {
                count++;
            }
        }
        if (index > list.length - 1 || index > count || item == null) {
            throw new ListIndexException();
        } else
            list[index] = item;
        return list[index];
    }

    @Override
    public String remove(String item) {
        String[] listCopy = new String[list.length - 1];
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == item) {
                System.arraycopy(list, 0, listCopy, 0, i);
                System.arraycopy(list, i + 1, listCopy, i, list.length - (i+1));
                list=listCopy;
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String[] listCopy = new String[list.length - 1];
        if (index > list.length - 1) {
            throw new ListIndexException();
        } else {
            for (int i = 0; i < list.length - 1; i++) {
                if (i == index) {
                    for (int k = 0; k < i; k++) {
                        listCopy[k] = list[k];
                    }
                    for (int j = i; j < list.length - 1; j++) {
                        listCopy[j] = list[j + 1];
                    }
                    break;
                }

            }
        }
        list=listCopy;
        return list[index];
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int i = list.length - 1;
        while (i >= 0) {
            if (list[i] == item) {
                return i;
            }
            i = i - 1;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        for (int i = 0; i < list.length - 1; i++) {
            if (i == index) {
                return list[i];
            }
        }
        return list[index];
    }

    public boolean equals(String[] otherList) {
        if (Arrays.equals(list, otherList) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        if (list.length != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void clear() {
        list = new String[0];
            }

    @Override
    public String[] toArray() {
        String[] newArr = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            newArr[i] = list[i];
        }
        return newArr;
    }

    @Override
    public String[] print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);

        }
        return list;
    }

    @Override
    public boolean equals(Object other) {
        ListImpl listImpl = (ListImpl) other;
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return Arrays.equals(list, listImpl.list);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(list);
    }
}

