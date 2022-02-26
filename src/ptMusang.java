import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class ptMusang {

Scanner sc = new Scanner(System.in);

Vector<String> vKHuruf = new Vector<>();
Vector<Integer> vKAngka = new Vector<>();
Vector<String> vKode = new Vector<>();
Vector<String> vNama = new Vector<>();
Vector<String> vKelamin = new Vector<>();
Vector<String> vJabatan = new Vector<>();
Vector<Integer> vGaji = new Vector<>();

	public ptMusang() {
		mainMenu();
	}
		
	public void mainMenu() {
		int choose;
		
		do {
			System.out.println("================|");
			System.out.println("Data Karyawan	|");
			System.out.println("================|");
			System.out.println("1. Insert	|");
			System.out.println("2. View		|");
			System.out.println("3. Update	|");
			System.out.println("4. Delete	|");
			System.out.println("________________|");
			System.out.print("choose>> ");
			choose = sc.nextInt();sc.nextLine();
			System.out.println("-----------------------");
			
			if (choose < 1 || choose > 4) {
				System.out.println("Please choose a number!");
				System.out.println("-----------------------");
			}
			else {
			switch (choose) {
			case 1:
				insertData();
				break;

			case 2:
				viewData();
				break;
			
			case 3:
				updateData();
				break;
			
			case 4:
				deleteData();
				break;
			}
			}
		} while (choose >1 || choose <4);

	}
		
	public void insertData() {
		
		String kode, kodeHuruf, nama, jenisKelamin, jabatan;
		Integer kodeAngka, gaji;
		
		do {
			System.out.print("Kode Huruf Karyawan [MM]: ");
			kodeHuruf = sc.nextLine();
		} while (!(kodeHuruf.length() == 2));
		
		do {
			System.out.print("Kode Angka Karyawan [XXXX]: ");
			kodeAngka = sc.nextInt();sc.nextLine();
		} while (!(kodeAngka > 999 && kodeAngka < 10000));
		
		kode = kodeHuruf + "-" + kodeAngka;
		
		if (vKode.indexOf(kode) ==0) {
			System.out.println("-------------------");
			System.out.println("Code's already taken!");
		}
		else {
			
		do {
			System.out.print("Nama Karyawan [Min 3 huruf]: ");
			nama = sc.nextLine();
		} while (nama.length()<3);
		
		do {
			System.out.print("Jenis Kelamin [Laki-laki / Perempuan] (Case Sensitive): ");
			jenisKelamin = sc.nextLine();
		} while (!(jenisKelamin.equals("Laki-laki") || jenisKelamin.equals("Perempuan")));
		
		do {
			System.out.print("Jabatan [Manager / Supervisor / Admin] (Case Sensitive): ");
			jabatan = sc.nextLine();
			
			if (jabatan.equals("Manager")) {
				gaji = 8000000;	
			}
			else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
			}
			else {
				gaji = 4000000;
			}
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		System.out.println("Berhasil menabahkan karyawan dengan id " + kode.toUpperCase());
		
		vKHuruf.add(kodeHuruf);
		vKAngka.add(kodeAngka);
		vKode.add(kode);
		vNama.add(nama);
		vKelamin.add(jenisKelamin);
		vJabatan.add(jabatan);
		vGaji.add(gaji);

		System.out.println("Enter to return..");sc.nextLine();
		}
	}
	
	
	public void viewData() {
		if (vNama.isEmpty()) {
			System.out.println("No name detected..");
			System.out.println("------------------");
			mainMenu();
		}
		else {
			
			System.out.println("No | Kode Karyawan | Nama Karyawan | Jenis Kelamin | Jabatan | Gaji Karyawan |");
			System.out.println("==============================================================================");
		
			for (int i = 0; i < vNama.size(); i++) {
			System.out.println((i+1) + " | " + vKode.get(i) + " | " + vNama.get(i) + " | " + vKelamin.get(i) + " | " + vJabatan.get(i) +" | " + vGaji.get(i) + " | ");
		}
		System.out.println("-----------------");
		System.out.println("Enter to return..");sc.nextLine();
		}
	}
	
	public void updateData() {
		viewData();
		
		Integer newKAngka, choose, newGaji;
		String newKode, newKHuruf, newNama, newKelamin, newJabatan;

		do {
			System.out.print("Nomor urutan karyawan yang ingin diupdate: ");
			choose = sc.nextInt();sc.nextLine();
		} while (choose < 1 || choose > vNama.size());
		
		do {
			System.out.print("Kode Huruf Karyawan [MM]: ");
			newKHuruf = sc.nextLine();
			if (newKHuruf.length()==2) {
				vKHuruf.set(choose-1, newKHuruf);
			}
			else if (newKHuruf.equals("0")) {
				
			}
		} while (!(newKHuruf.length() ==2 || newKHuruf.equals("0")));
		
		do {
			System.out.print("Kode Angka Karyawan [XXXX]: ");
			newKAngka = sc.nextInt();sc.nextLine();
			if (newKAngka >999 && newKAngka < 10000) {
				vKAngka.set(choose-1, newKAngka);
			}
			else if (newKAngka == 0) {
				
			}
		} while (!(newKAngka >999 && newKAngka < 10000 || newKAngka == 0));
		
		newKode = vKHuruf.get(choose-1) + "-" + vKAngka.get(choose-1);
			
		do {
			System.out.print("Nama Karyawan [>= 3]: ");
			newNama = sc.nextLine();
			if (newNama.length()>3) {
				vNama.set(choose-1, newNama);
			}
			else if (newNama.equals("0")) {
				
			}
		} while (!(newNama.length()>3 || newNama.equals("0")));		
		
		do {
			System.out.print("Jenis Kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			newKelamin = sc.nextLine();
			if (newKelamin.equals("Laki-laki") || newKelamin.equals("Perempuan")) {
				vKelamin.set(choose-1, newKelamin);
			}
			else if (newKelamin.equals("0")) {
				
			}
		} while (!(newKelamin.equals("Laki-laki") || newKelamin.equals("Perempuan") || newKelamin.equals("0")));

		do {
			System.out.print("Jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			newJabatan = sc.nextLine();
			if (newJabatan.equals("Manager")) {
				newGaji = 8000000;
			}
			else if (newJabatan.equals("Supervisor")) {
				newGaji = 6000000;
			}
			else {
				newGaji = 4000000;
			}
			if (newJabatan.equals("Manager") || newJabatan.equals("Supervisor") || newJabatan.equals("Admin")) {
				vJabatan.set(choose-1, newJabatan);
				vGaji.set(choose-1, newGaji);
			}
			else if (newJabatan.equals("0")) {
				
			}
		} while (!(newJabatan.equals("Manager") || newJabatan.equals("Supervisor") || newJabatan.equals("Admin") || newJabatan.equals("0")));
	
		vKode.set(choose-1, newKode);
		
		System.out.println("Berhasil mengupdate karyawan dengan id " + vKode.get(choose-1));
		System.out.println("Enter to return..");sc.nextLine();
	}
	
	
	public void deleteData() {
		viewData();
		
		int choose;

		do {
			System.out.print("Nomor urutan karyawan yang ingin dihapus: ");
			choose = sc.nextInt();sc.nextLine();
		} while (choose < 1 || choose > vNama.size());

		System.out.println("Karyawan dengan kode " + vKode.get(choose-1) + " berhasil dihapus");
		
		vNama.remove(choose-1);
		vKode.remove(choose-1);
		vKelamin.remove(choose-1);
		vJabatan.remove(choose-1);
		vGaji.remove(choose-1);
		
		System.out.println("Enter to return..");sc.nextLine();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ptMusang();

	}

}