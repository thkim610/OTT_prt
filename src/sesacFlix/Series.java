package sesacFlix;

import java.util.List;

public class Series extends Contents{

	List<String> seriesId;
	OTTArchive otA;
	
	public Series(OTTArchive otA,String key) {
		super(otA, key);
		this.otA = otA;
		this.seriesId = medias;
	}
	
	void seriesInfo() {
		
		for(int i=0; i<seriesId.size(); i++) {
			System.out.println(i+1+".------------------");
			System.out.println(i+1+"ȸ ����");
			System.out.println("�ø��� ����: "+otA.mediaM.get(seriesId.get(i)).get("title"));
			System.out.println("����ð�: "+ otA.mediaM.get(seriesId.get(i)).get("time"));
			System.out.println();
		}
		
	}
}