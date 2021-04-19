using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;
namespace 图书管理
{
	class Manage
	{
		DBOperation db = new DBOperation();
		public bool Login()
		{
			Console.WriteLine("请输入账号");
			string loginid =Console.ReadLine();
			Console.WriteLine("请输入密码");
			string loginPwd = Console.ReadLine();
			string message = string.Empty;
			bool isRight=db.Login(loginid,loginPwd,ref message);
			if (isRight)
			{
				return true;
			}
			else
			{
				Console.WriteLine(message);
				return false;
				
			}
		}
		public void ShowMenu()
		{
			if (!Login())
			{
				return;
			}
			bool isRight = false;
			do
			{
				Console.WriteLine("".PadLeft(30,'=')+"欢迎登陆图书管理系统".PadRight(30,'='));
                Console.WriteLine("".PadLeft(30, ' ') + "1.查看全部图书");
                Console.WriteLine("".PadLeft(30, ' ') + "2.插入图书信息");
                Console.WriteLine("".PadLeft(30, ' ') + "3.修改图书信息");
                Console.WriteLine("".PadLeft(30, ' ') + "4.删除图书信息");
                Console.WriteLine("".PadLeft(30, ' ') + "5.退出");
                Console.WriteLine("".PadLeft(75, '='));
				Console.Write("请选择:");
                int choice;
                if (!int.TryParse(Console.ReadLine(),out choice))
                {
                    Console.WriteLine("请输入正整数！");
                    continue;
                }
				switch (choice)
				{
					case 1:
						ShowBook();
						break;
					case 2:
						InsertBook();
						break;
					case 3:
						UpdatePrice();
						break;
					case 4:
						Delete();
						break;
					case 5:
						isRight = true;
						Console.WriteLine("程序退出谢谢使用");
						break;

					default:
						break;
				}
			} while (!isRight);
		}

		private void Delete()
		{
			Console.WriteLine("请输入图书编号");
			int id = int.Parse(Console.ReadLine());
			string message = string.Empty;
			SqlDataReader sdr = db.GETBookID(id,ref message);
			if (sdr == null)
			{
				Console.WriteLine(message);
				return;
			}
			if (!sdr.HasRows)
			{
				Console.WriteLine("没有这本书");
				return;
			}
			Console.WriteLine("图书编号\t名称\t类别\t数量\t价格");
			while (sdr.Read())
			{
				Console.WriteLine("{0}\t\t{1}\t{2}\t{3}\t{4}", sdr["id"], sdr["name"], sdr["typeName"], sdr["number"], sdr["price"]);
			}
			sdr.Close();
			Console.WriteLine("是否删除(y/n)");
			string r = Console.ReadLine().Trim().ToLower();
			if (r!="y")
			{
				return;
			}
			message=null;
			int result = db.Delete(id, ref message);
			if (result ==-1)
			{
				Console.WriteLine(message);
				return;
			}
			Console.WriteLine("删除了{0}条记录",result);

		}

		private void UpdatePrice()
		{
			Console.WriteLine("请输入图书编号");
			int id = int.Parse(Console.ReadLine());
			Console.WriteLine("请输入价格");
			double price = double.Parse(Console.ReadLine());
			string message = string.Empty;
			int result = db.UpdatePrice(id,price, ref message);
			if (result==-1)
			{
				Console.WriteLine(message);
				return;
			}
			if (result==0)
			{
				Console.WriteLine("该图书不存在");
				return;
			}
			Console.WriteLine("修改了{0}行记录",result);
		}

		private void ShowBook()
		{
			string message =string.Empty;
			SqlDataReader sdr = db.ShowBook(ref message);
			if (sdr == null)
			{
				Console.WriteLine(message);
				return;
			}
			Console.WriteLine("图书编号\t名称\t类别\t数量\t价格");
			while (sdr.Read())
			{
                Console.WriteLine("{0}\t\t{1}\t{2}\t{3}\t{4}", sdr["id"],sdr["name"],sdr["typeName"],sdr["number"],sdr["price"]);
			}
			sdr.Close();
		}

		private bool GETBookID(int bookId )
		{
			string messsage = string.Empty;
			SqlDataReader sdr = db.GETBookID(bookId,ref messsage);
			if (sdr.HasRows)
			{
				return false;
			}
			Console.WriteLine(messsage);
			sdr.Close();
			return true;
		}
		private bool GETBookTypeBYID(int typeid)
		{
			string messsage = string.Empty;
			SqlDataReader sdr = db.GETBookID(typeid, ref messsage);
			if (sdr!=null&&sdr.HasRows )
			{
				return true;
			}
			Console.WriteLine(messsage);
			sdr.Close();
			return false;
		}

		private void InsertBook()
		{
			Book b = new Book();
			Console.WriteLine("请输入图书编号");
			b.Id=int.Parse(Console.ReadLine());
			if (!GETBookID(b.Id))
			{
				Console.WriteLine("该编号已存在请重新插入");
				return;
			}
			Console.WriteLine("请输入图书名称");
			b.Name = Console.ReadLine();
			
			Console.WriteLine("请输入类别编号");
			b.TypeId = int.Parse(Console.ReadLine());
			if (!GETBookTypeBYID(b.TypeId))
			{
				Console.WriteLine("该类别不存在请重新输入");
				return; 
			}
			Console.WriteLine("请输入数量");
			b.Number = int.Parse(Console.ReadLine());
			Console.WriteLine("请输入单价");
			b.Price = double.Parse(Console.ReadLine());
			string message =string.Empty;
			int result = db.InsertBook(b, ref message);
			if (result==-1)
			{
				Console.WriteLine(message);
				return;
			}
			Console.WriteLine("插入了{0}行数据",result);
		}
	}
}
