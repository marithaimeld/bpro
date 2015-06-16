import java.util.*;
import java.io.*;

public class penjualanUas
{
	//deklarasi vektor
	public static Vector<Vector> brg = new Vector<Vector>();
	public static Vector<Vector> cs = new Vector<Vector>();
	public static Vector<Vector> dp = new Vector<Vector>();
	
	//method untuk menyimpan barang 
	public static Vector<Object> addb(String nb,int hj,int hb)
	{
		Vector <Object> barang = new Vector<Object>();
		barang.addElement(nb);
		barang.addElement(String.valueOf(hj));
		barang.addElement(String.valueOf(hb));
		return barang;
	}
	
	public static Vector<Object> print(String nb,int h,int j,int ht)
	{
		Vector <Object> struk = new Vector<Object>();
		struk.addElement(nb);
		struk.addElement(h);
		struk.addElement(j);
		struk.addElement(ht);
		return struk;
	}
	
	//array
	public static String [][] datauser= 
	{
		{"admin","mimin"}
	};
  
	
	public static void main(String[]args) throws IOException
	{
		BufferedReader ii = new BufferedReader(new InputStreamReader(System.in));
		Scanner i = new Scanner(System.in);
		Vector<Vector> v = new Vector<Vector>();
		brg.addElement(addb("Coca-Cola",3000,2500));
		brg.addElement(addb("Fanta",5000,4000));
		brg.addElement(addb("Tehbotol Sosro",4500,3000));
		brg.addElement(addb("Aqua",2000,1500));
		int jum = brg.size();
		int jml = 0;
		int keluar = 0;
		int untung = 0 ;
		int d = 0;
		Date date = new Date();

		int login=-1;
		int count=0;
		
		do
		{
			Scanner sc =new Scanner(System.in);
			System.out.println ("~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println ("     LOGIN DAHULU");
			System.out.println ("~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println ("Kesempatan Login 3x");
			System.out.print ("Username : ");
			String user=sc.next();
			System.out.print ("Password : ");
			String pass =sc.next();
			System.out.println();
			
			if (user.equals(datauser[0][0]) && pass.equals(datauser[0][1]))
			{  
				login=0;  
				keluar=0;
				break;
			}
			else 
			{
				System.out.println ("----------------------------------------------------------");
				System.out.println ("Maaf Username dan Password salah. Silahkan login kembali");
				System.out.println ("----------------------------------------------------------");
				System.out.println ();
				login=-1;
				keluar = 1;
			}
			count++;
		}
		while (count<3);

		if (count==3)
		{
			System.out.println ("SYSTEM EROR!! COBA KEMBALI NANTI.");
			keluar = 1;
		}
			
		
		while(keluar == 0)
		{
			System.out.println("-------------------------");
			System.out.println("     SELAMAT DATANG");
			System.out.println("-------------------------");
			System.out.println("1. Beli");
			System.out.println("2. Tambah Data Barang");
			System.out.println("3. Update Data Barang");
			System.out.println("4. Hapus Data Barang");
			System.out.println("5. Cek Data Penjualan");
			System.out.println("6. Data Barang");
			System.out.println("7. Cari Data Barang");
			System.out.println("8. Pendapatan");
			System.out.println("9. Keluar");
			System.out.print("Masukkan pilihan (1-9) : ");
			
			int pilih = i.nextInt();
			switch (pilih)
			{
				case 1:
					Vector<String> struk = new Vector<String>();
					int lagi = 1;
					int t = 0;
					System.out.println();
					System.out.println("-------------------------");
					System.out.println("      DATA BARANG");
					System.out.println("-------------------------");	
					for (int c=0 ; c<jum ; c++)
					{
						System.out.print(c+1 +"  ");
						System.out.print(brg.elementAt(c).elementAt(0) +" @Rp " +brg.elementAt(c).elementAt(1));
						System.out.println();
					}

					while(lagi == 1)
					{
						System.out.println();
						System.out.print("Masukkan nomor barang yang akan dibeli : ");
						int beli = i.nextInt()-1;
						System.out.print("Jumlah : ");
						int juml = i.nextInt();
						System.out.println("---------------------------------------------");
						
						int ht = juml*Integer.valueOf((String) brg.elementAt(beli).elementAt(1));
						
						cs.addElement(print((String)brg.elementAt(beli).elementAt(0),Integer.valueOf((String)brg.elementAt(beli).elementAt(1)),juml,ht));
						
						
						System.out.println(cs.size());
						System.out.println(brg.elementAt(beli).elementAt(0) +" " +juml +" botol : Rp " +ht);
						t += ht;
						untung += juml*(Integer.valueOf((String) brg.elementAt(beli).elementAt(1))-Integer.valueOf((String) brg.elementAt(beli).elementAt(2)));
						
						int lg = 0;
						while (lg==0)
						{
							System.out.println("----------------------------");
							System.out.println();
							System.out.println("Ingin beli lagi ? ");
							System.out.print("(1 = Ya , 0 = Tidak) : ");
							lagi = i.nextInt();
							System.out.println("----------------------------");
							if((lagi == 0) || (lagi==1))
							{
								lg = 1;
							}
							else
							{
								System.out.println();
								System.out.println("Angka yang anda masukkan salah");
								System.out.println();
								lg=0;
							}
						}
					}
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("        TERIMA KASIH");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						
						while( d < cs.size())
						{
							System.out.print(cs.elementAt(d).elementAt(0) +" (" +cs.elementAt(d).elementAt(2) +") " +"= Rp " +cs.elementAt(d).elementAt(3));
							System.out.println();
							d++;
						}

					System.out.println();
					System.out.println("Total : Rp " +t);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println(date);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					break;
					
				case 2:
					System.out.println();
					System.out.print("Masukkan Jumlah Tambah Barang : ");
					jml = i.nextInt();
					jum += jml;
					for (int a = 0 ; a < jml ; a++)
					{
						System.out.print("Masukkan Nama Barang : ");
						String nb = i.next();
						System.out.print("Masukkan Harga Jual : ");
						int hj = i.nextInt();
						System.out.print("Masukkan Harga Beli : ");
						int hb = i.nextInt();
					
						brg.addElement(addb(nb,hj,hb));
						System.out.println(brg.size());
						System.out.println();
						System.out.println("Data telah ditambahkan");
						System.out.println();
					}
					break;

				case 3:
					System.out.println();
					System.out.print("Masukkan nomor barang yang akan diedit : ");
					int nbb = i.nextInt();
					System.out.print("Masukkan harga jual baru : ");
					int hjb = i.nextInt();
					System.out.print("Masukkan harga beli baru : ");
					int hbb = i.nextInt();
					
					String sbb = (String)brg.elementAt(nbb-1).elementAt(0);
					brg.setElementAt(addb(sbb,hjb,hbb),nbb-1);
					
					System.out.println();
					System.out.println("Harga telah diupdate");
					System.out.println();
					break;

				case 4:
					lagi = 1;
					while (lagi == 1)
					{
						System.out.println();
						System.out.print("Masukkan nomor barang yang akan dihapus : ");
						int hapus = i.nextInt()-1;
						jum -= 1;
						brg.removeElementAt(hapus);
						System.out.println();
						System.out.println("Data telah dihapus");
						
						int lg = 0;
						while (lg==0)
						{
							System.out.println();
							System.out.println("----------------------------");
							System.out.println("Ingin menghapus lagi ? ");
							System.out.print("(1 = Ya , 0 = Tidak) : ");
							lagi = i.nextInt();
							System.out.println("----------------------------");
							System.out.println();
							if((lagi == 0) || (lagi==1))
							{
								lg = 1;
							}
							else
							{
								System.out.print("Angka yang anda masukkan salah");
								System.out.println();
								lg=0;
							}
						}
					}
					break;

				case 5:
					System.out.println();
					System.out.println("-------------------------");
					System.out.println("      DATA BARANG");
					System.out.println("-------------------------");
					for (int a = 0 ; a < jum ; a++)
					{
						System.out.print(a+1 +"  ");
						System.out.print(brg.elementAt(a).elementAt(0) +": Harga Jual = Rp " +brg.elementAt(a).elementAt(1) +", Harga Beli = Rp " +brg.elementAt(a).elementAt(2));

						System.out.println();
					}
					System.out.println();
					System.out.print("Tekan enter untuk kembali");
					ii.readLine();
					System.out.println();
					break;

				case 6:
					Vector<String> data = new Vector<String>();
					
					System.out.println();
					System.out.println("-------------------------");
					System.out.println("      DATA BARANG");
					System.out.println("-------------------------");	
					for (int c=0 ; c<jum ; c++)
					{
						System.out.print(c+1 +"  ");
						System.out.print(brg.elementAt(c).elementAt(0) +" @Rp " +brg.elementAt(c).elementAt(1));
						System.out.println();
					}

					System.out.println("-------------------------");	
					System.out.println();	
					break;
					
				case 7:
					System.out.println();
					System.out.print("Masukkan Nama Barang: ");
					String cari = "a";
					cari = i.next();
					System.out.println("-------------------------------");					
	
					int in=0;
					int x=0;
					int indeks = -1;
					do
					{
						String con = (String)brg.elementAt(in).elementAt(0);
						if(con.toLowerCase().contains(cari.toLowerCase()) == true)
						{
							System.out.println("      " + (String)brg.elementAt(in).elementAt(0) + " @" +(String)brg.elementAt(in).elementAt(1));
							x = 1;
							System.out.println("-------------------------------");
						} 
						in++;
					}
					while((in<brg.size())&&(indeks == -1));

					if(x==0)
					{
						System.out.println("Barang yang anda cari tidak ada");
						System.out.println("-------------------------------");
						System.out.println();
					}
					break;

				case 8:
					System.out.println();
					System.out.println("---------------------------");
					System.out.println("Laba bersih : Rp " +untung);
					System.out.println("---------------------------");
					System.out.println();
					break;
					
				case 9:
					keluar = 1;
					break;
			}
		}
	}
}
