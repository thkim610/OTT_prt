package sesacFlix;

public class Movie extends Contents{

	String movieId;
	String prevId;
	OTTArchive otA;
	
	public Movie(OTTArchive otA,String key) {
		super(otA, key);
		this.otA = otA;
		this.movieId = medias.get(0);
		this.prevId = medias.get(1);
	}
	
	void movieInfo() {
		
		
		System.out.println("1.------------");
		System.out.println("���� ����");
		System.out.println("����: "+ otA.mediaM.get(movieId).get("title"));
		System.out.println("����ð�: "+ otA.mediaM.get(movieId).get("time"));
		System.out.println("2.------------");
		System.out.println("������ ����");
		System.out.println("����: "+ otA.mediaM.get(prevId).get("title"));
		System.out.println("����ð�: "+ otA.mediaM.get(prevId).get("time"));
		System.out.println();
		
		

		
	}
	
}