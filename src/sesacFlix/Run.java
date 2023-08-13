package sesacFlix;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OTTArchive o = new OTTArchive();
		User u = new User(123, "kim");
		OTT ott = new OTT(o, u);

		while (true) {

			System.out.println("�޴��� �������ּ���.");
			System.out.println("1. ������ ����");
			System.out.println("2. ��ȭ ������");
			System.out.println("3. �ø��� ������");
			System.out.println("4. ���ɸ�� ������");
			System.out.println("0. ����");

			int num = sc.nextInt();
			int contentsNum;

			if (num == 0) {
				System.out.println("���α׷� ����");
				break;
			}

			//������ ����
			if (num == 1) {
				ott.rankContents();
			//��ȭ ������
			} else if (num == 2) {
				ott.movieContents();
			//�ø��� ������
			} else if (num == 3) {
				ott.seriesContents();
			//���ɸ�� ������
			} else if(num == 4){
				ott.favoriteContents();
			}
			
			//������ ������ ���γ��� �����ֱ�
			System.out.println("���� ���� �������� ��ȣ�� �Է����ּ���.");
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