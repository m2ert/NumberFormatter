package numberFormatter;

public class Test {
	
	public static String addCommasToNumber(String number,String seperatorObject) {
		
		
		int numberLength= number.length(); /* String'in lenght deðerini aldýk */
		int totalSeperator = (int) Math.floor((numberLength-1)/3); /* Toplam kaç tane virgül kullanacaðýmýzý belirledik */
		
		String formattedString = number.substring(0,numberLength-(totalSeperator*3)); /* Soldan ilk deðeri alýyoruz bu örnek için sonuç: 12 */

		while (totalSeperator > 0)    { /* totalSeperator > 0 olduðu müddetçe tekrarlanacak */
		formattedString = 
				formattedString + /* Daha önce aldýðýmýz soldan deðer 12 */
				seperatorObject + /* , */
				number.substring(numberLength-(totalSeperator*3),numberLength-((totalSeperator-1)*3)); 
		/* 
		 * Ýlk deðeri aldýktan sonra geri kalanýn virgülle ayrýlmasý
		 * 345,678 bu örnek için	
		*/
		totalSeperator = totalSeperator - 1;   /* Döngü tekrarlayacaðý için total deðeri -1 azalttýk */
		
		}
		  /* Çýkan sonuç */
		return formattedString;
	}
	
	public static void main(String[] args) {
		
		System.out.println(addCommasToNumber("12345678",","));
	}
}
