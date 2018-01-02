package systemscanner;

import java.io.File;

public class GereksizDosyaTarayici {
	int sayac = 0;
	int byte_kazanc = 0;
	LinkedList hatalist;
	int silinen = 0;
	int silinemeyen = 0;
	public GereksizDosyaTarayici()
	{
		hatalist = new LinkedList();		
	}
	public LinkedList Tara(LinkedList liste) 
	{
		
		
		String dirname = liste.Head.Value;
		File f1 = new File(dirname);
		if (f1.isDirectory())
		{ 
			String s[] = f1.list(); 
			for (int i=0; i < s.length; i++)
			{ 
				File f = new File(dirname + "/" + s[i]); 
				String tmp = dirname + "/" + s[i];
				if (f.isDirectory())
				{ 
					liste.InsertLast(tmp);
					} 
				else 
				{ 
					
					sayac++;
					byte_kazanc += f.length()/1024;
					hatalist.InsertFirst(dirname + "/" + s[i]);
					} 
				} 
			} 
		else
		{
			
		}
					
		if(liste.Head.Next != null)
		{
			liste.DeleteFirst();
			Tara(liste);
		}
		return hatalist;		
	}
	public void Temizle(String[] temizle_list)
	{
		
		int hatasayisi = temizle_list.length;
		
		
		for(int i = 0; i < hatasayisi; i++)
		{
			File file = new File(temizle_list[i]);

			if(file.delete()){
				silinen++;
			}else{
				silinemeyen++;
			}
		}
	}
}
