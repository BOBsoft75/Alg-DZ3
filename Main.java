import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    SingleLinkList<Contact> contactList = new SingleLinkList<>();

    contactList.addToEnd(new Contact(001, "Иванов Иван Иванович", "+79111112233"));
    contactList.addToEnd(new Contact(002, "Петров Петр Петрович", "+79055556677"));
    contactList.addToEnd(new Contact(003, "Семенов Семен Семенович", "+79213334499"));
    contactList.addToEnd(new Contact(004, "Олегов Олег Олегович", "+79818885522"));
    contactList.addToEnd(new Contact(005, "Николаев Николай Николаевич", "+79046664455"));
    contactList.addToEnd(new Contact(006, "Федоров Федор Федорович", "+79034567890"));
    contactList.addToEnd(new Contact(007, "Владимиров Владимир Владимирович", "+79118524697"));
    contactList.addToEnd(new Contact(010, "Михайлов Михаил Михайлович", "+79212145698"));
    contactList.addToEnd(new Contact(011, "Степанов Степан Степанович", "+79051154687"));


    for (Object contact : contactList) {
      System.out.println(contact);
    }
    contactList.reverse();

    System.out.println("================== Reverse List: ==================");

    for (Object contact : contactList) {
      System.out.println(contact);
    }
  }

  static class Contact {

    int id;
    String name;
    String phone;

    public Contact(int id, String name, String phone) {
      this.id = id;
      this.name = name;
      this.phone = phone;
    }

    @Override
    public String toString() {
      return "Contact{" +
          "id = " + id +
          ", name = '" + name + '\'' +
          ", phone = '" + phone + '\'' +
          '}';
    }
  }


  public static class SingleLinkList<T> implements Iterable {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator iterator() {
      return new Iterator<T>() {
        ListItem<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          T data = current.data;
          current = current.next;
          return data;
        }
      };
    }
    
     private static class ListItem<T> {

      T data;
      ListItem<T> next;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public void addToEnd(T item) {

      ListItem<T> newItem = new ListItem<>();
      newItem.data = item;
     
      if (isEmpty()) {
        head = newItem;
        tail = newItem;
      } else { 
        tail.next = newItem;
        tail = newItem;
      }
    }


    public void reverse() {
      if (!isEmpty() && head.next != null) {
        tail = head;
        ListItem<T> current = head.next;
        head.next = null;
        while (current != null) {
          ListItem<T> next = current.next;
          current.next = head;
          head = current;
          current = next;
        }
      }
    }
  }
}