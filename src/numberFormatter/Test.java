package numberFormatter;

public class Test {
	
	public static String addCommasToNumber(String number,String seperatorObject) {
		
		
		int numberLength= number.length(); /* String'in lenght de�erini ald�k */
		int totalSeperator = (int) Math.floor((numberLength-1)/3); /* Toplam ka� tane virg�l kullanaca��m�z� belirledik */
		
		String formattedString = number.substring(0,numberLength-(totalSeperator*3)); /* Soldan ilk de�eri al�yoruz bu �rnek i�in sonu�: 12 */

		while (totalSeperator > 0)    { /* totalSeperator > 0 oldu�u m�ddet�e tekrarlanacak */
		formattedString = 
				formattedString + /* Daha �nce ald���m�z soldan de�er 12 */
				seperatorObject + /* , */
				number.substring(numberLength-(totalSeperator*3),numberLength-((totalSeperator-1)*3)); 
		/* 
		 * �lk de�eri ald�ktan sonra geri kalan�n virg�lle ayr�lmas�
		 * 345,678 bu �rnek i�in	
		*/
		totalSeperator = totalSeperator - 1;   /* D�ng� tekrarlayaca�� i�in total de�eri -1 azaltt�k */
		
		}
		  /* ��kan sonu� */
		return formattedString;
	}
	
	public static void main(String[] args) {
		
		System.out.println(addCommasToNumber("12345678",","));
	}
}
