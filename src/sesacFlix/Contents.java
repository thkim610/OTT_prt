package sesacFlix;

import java.util.LinkedList;
import java.util.List;

public class Contents implements Comparable<Contents>{
	
	List<Contents> contentList = new LinkedList<Contents>();

	protected String cId;
	protected String title;
	protected String direc;
	protected String summary;
	protected String cast;
	protected String year;
	protected int views;
	protected String type;
	protected List<String> medias;
	protected OnFavorite onFavorite;
	
	
	public Contents(OTTArchive otA, String key) {
		this.cId = key;
		this.title = (String) otA.contentM.get(key).get("title");
		this.direc = (String) otA.contentM.get(key).get("direc");
		this.summary = (String) otA.contentM.get(key).get("summary");
		this.cast = (String) otA.contentM.get(key).get("cast");
		this.year = (String) otA.contentM.get(key).get("year");
		this.views = (int) otA.contentM.get(key).get("views");
		this.type = (String) otA.contentM.get(key).get("type");
		this.medias = (List<String>) otA.contentM.get(key).get("medias");
	}

	//찜 목록 추가기능 인터페이스
	public interface OnFavorite{
		void addFavorite(String key);
	}
	
	public void setOnFavorite(OnFavorite onFavorite) {
		this.onFavorite = onFavorite;
	}
	
	// 콘텐츠 찜하기 기능
	void addfContents() {
		onFavorite.addFavorite(cId);
		System.out.println(title+"(이)가 찜 목록에 추가되었습니다.");
	}
	
	@Override
	public int compareTo(Contents contents) {
        if (contents.views > views) {
            return 1;
        } else if (contents.views < views) {
            return -1;
        }
        return 0;
    }
	
}