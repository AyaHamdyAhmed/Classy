
public class tryurl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "https://testprod.classy.org/manage/event/249711/overview";
		System.out.println(url);
		url = url.replaceAll("[0-9]", "");
		System.out.println(url);
	}

}
