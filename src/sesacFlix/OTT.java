package sesacFlix;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OTT {

	protected OTTArchive otA;
	List<Contents> contentList = new LinkedList<Contents>();
	List<String> cIdList = new LinkedList<String>();
	List<String> mIdList = new LinkedList<String>();
	int contentNum;

	public OTT(OTTArchive otA) {
		this.otA = otA;
	}

	//아카이브에서 컨텐츠 Id를 가져와 리스트로 저장
	void setcList() {
		cIdList.addAll(otA.contentM.keySet());

	}

	//아카이브에서 미디어 Id를 가져와 리스트로 저장
	void setmList() {
		mIdList.addAll(otA.mediaM.keySet());
	}

	//컨텐츠의 제목, 줄거리, 타입을 보여줌.
	void showContentsList() {
		for (int i = 0; i < contentList.size(); i++) {
			System.out.println(i + 1 + ".---------------------------");
			System.out.println("제목: " + contentList.get(i).title);
			System.out.println("줄거리: " + contentList.get(i).summary);
			System.out.println(contentList.get(i).type);
			System.out.println(contentList.get(i).views);
			System.out.println();
		}
	}

	//컨텐츠 순위 목록(조회수 순)
	void rankContents() {
		setcList();

		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			key = cIdList.get(i);
			Contents c = new Contents(otA, key);

			this.contentList.add(c);

		}

		Collections.sort(contentList);

		System.out.println("컨텐츠 순위!!");
		showContentsList();

	}
	
	//영화 컨텐츠 목록
	void movieContents() {
		setcList();

		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("영화")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("영화 컨텐츠");
		showContentsList();
	}

	//시리즈 컨텐츠 목록
	void seriesContents() {
		setcList();

		for (int i = 0; i < otA.contentM.size(); i++) {
			String key;
			if (otA.contentM.get(cIdList.get(i)).get("type").equals("시리즈")) {

				key = cIdList.get(i);
				Contents c = new Contents(otA, key);

				this.contentList.add(c);
			}

		}

		Collections.sort(contentList);

		System.out.println("시리즈 컨텐츠");
		showContentsList();

	}

	//컨테츠 번호 입력 시, 세부내용 보여줌. 
	void detailContent(int contentNum) {
		this.contentNum = contentNum - 1;
		Contents detailList = contentList.get(this.contentNum);

		System.out.println("제목: " + detailList.title);
		System.out.println("줄거리: " + detailList.summary);
		System.out.println("감독: " + detailList.direc);
		System.out.println("연도: " + detailList.year);
		System.out.println("출연: " + detailList.cast);
		System.out.println(detailList.type);
		System.out.println(0+". 찜하기");
		System.out.println();

		if (detailList.type.equals("영화")) {

			Movie m = new Movie(otA, detailList.cId);
			m.movieInfo();
		} else if (detailList.type.equals("시리즈")) {
			Series s = new Series(otA, detailList.cId);
			s.seriesInfo();

		}

	}

}
