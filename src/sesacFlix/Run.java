package sesacFlix;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OTTArchive o = new OTTArchive();
		OTT ott = new OTT(o);

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
			}
			
			//������ ������ ���γ��� �����ֱ�
			System.out.println("���� ���� �������� ��ȣ�� �Է����ּ���.");
			contentsNum = sc.nextInt();
			ott.detailContent(contentsNum);
			
			
		}

		sc.close();

	}
}