package LinkedList;

class Info{
	private int id;
	@Override
	public String toString() {
		return "Info [id=" + id  + "]";
	}
	public void setId(int id){

	this.id=id;
	}
	public int getId(){
		return id;
	}
	
}

class Information extends Info{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Information [name=" + name + ", getId()=" + getId() + "]";
	}
	
}

class Messager<T extends Info> {
	private T msg;

	public void setMsg(T m) {
		msg = m;
	}

	public T getMsg() {
		return msg;
	}
}

public class TestDemo {

	public static void main(String[] args) {
		Messager<Information> aa = new Messager<>();
		Information i = new Information();
		i.setId(9);
		i.setName("haha");
		aa.setMsg(i);
		fun(aa);
	}

	public static void fun(Messager<? extends Info> msg) {
		System.out.println(msg.getMsg());
	}
}
