package sesacFlix;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OTTArchive o = new OTTArchive();
		User u = new User(123, "kim");
		OTT ott = new OTT(o, u);

		while (true) {

			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1. 컨텐츠 순위");
			System.out.println("2. 영화 컨텐츠");
			System.out.println("3. 시리즈 컨텐츠");
			System.out.println("4. 관심목록 컨텐츠");
			System.out.println("0. 종료");

			int num = sc.nextInt();
			int contentsNum;

			if (num == 0) {
				System.out.println("프로그램 종료");
				break;
			}

			//컨텐츠 순위
			if (num == 1) {
				ott.rankContents();
			//영화 컨텐츠
			} else if (num == 2) {
				ott.movieContents();
			//시리즈 컨텐츠
			} else if (num == 3) {
				ott.seriesContents();
			//관심목록 컨텐츠
			} else if(num == 4){
				ott.favoriteContents();
			}
			
			//선택한 컨텐츠 세부내용 보여주기
			System.out.println("보고 싶은 컨텐츠의 번호를 입력해주세요.");
			contentsNum = sc.nextInt();
			Contents selectContents =  ott.detailContent(contentsNum);
			
			int favorNum = sc.nextInt();
			if(favorNum == 0) {
				selectContents.addfContents();
			}
		}

		sc.close();

	}
}