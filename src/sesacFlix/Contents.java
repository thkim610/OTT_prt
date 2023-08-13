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