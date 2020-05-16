using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace 图书管理
{
	class DBOperation
	{
		const string CONNSTR = "server=.;database=Libray;uid=sa;pwd=xuminglu021816;";
		StringBuilder sql = new StringBuilder();
		public bool Login(string loginid, string loginPwd, ref string message)
		{
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("SELECT count(*)");
				sql.AppendLine("  FROM");
                sql.AppendLine("    [User]");
				sql.AppendLine("    where ");
				sql.AppendFormat("loginid='{0}'and loginpwd='{1}'", loginid, loginPwd);
				sql.AppendLine("");
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				int result = (int)cmd.ExecuteScalar();
				if (result == 1)
				{
					return true;
				}
				else
				{
					message = "账号或密码错误";
					return false;

				}
			}
			catch (Exception ex)
			{
				message = string.Format("错误信息{0}", ex.Message);
				return false;
			}
			finally
			{
				cnn.Close();
			}
		}
		public int InsertBook(Book b, ref string message)
		{
			int result = -1;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("INSERT INTO [Book]");
				sql.AppendLine("           ([id]");
				sql.AppendLine("           ,[name]");
				sql.AppendLine("           ,[typeId]");
				sql.AppendLine("           ,[number]");
				sql.AppendLine("           ,[price])");
				sql.AppendLine(" VALUES (");
				sql.AppendFormat("'{0}'", b.Id);
				sql.AppendFormat(",'{0}'", b.Name);
				sql.AppendFormat(",'{0}'", b.TypeId);
				sql.AppendFormat(",'{0}'", b.Number);
				sql.AppendFormat(",'{0}'", b.Price);
				sql.AppendLine(" )");
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				result = cmd.ExecuteNonQuery();
			}
			catch (Exception ex)
			{
				message = string.Format("错误信息{0}", ex.Message);

			}
			finally
			{
				cnn.Close();
			}
			return result;
		}
		public SqlDataReader GETBookID(int bookId, ref string message)
		{
			SqlDataReader sdr = null;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("SELECT [id]");
				sql.AppendLine("      ,[name]");
				sql.AppendLine("      ,[typeName]");
				sql.AppendLine("      ,[number]");
				sql.AppendLine("      ,[price]");
				sql.AppendLine("  FROM [Book] as b");
                sql.AppendLine("join [BookType] as t on t.typeid =b.typeid ");
				sql.AppendLine("where ");
				sql.AppendFormat(" id ='{0}'", bookId);
				sql.AppendLine("");
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				sdr = cmd.ExecuteReader(CommandBehavior.CloseConnection);

			}
			catch (Exception ex)
			{

				message = string.Format("错误信息{0}", ex.Message);
			}

			return sdr;
		}
		public SqlDataReader ShowBook(ref string message)
		{
			SqlDataReader sdr = null;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("SELECT [id]");
				sql.AppendLine("      ,[name]");
				sql.AppendLine("      ,[typeName]");
				sql.AppendLine("      ,[number]");
				sql.AppendLine("      ,[price]");
				sql.AppendLine("  FROM [Book] as b");
				sql.AppendLine("join [BookType] as t on t.typeid =b.typeid ");
				sql.AppendLine("");
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				sdr = cmd.ExecuteReader(CommandBehavior.CloseConnection);

			}
			catch (Exception ex)
			{

				message = string.Format("错误信息{0}", ex.Message);
			}

			return sdr;
		}
		public SqlDataReader GETTypeID(int TypeID, ref string message)
		{
			SqlDataReader sdr = null;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("SELECT [TypeID]");
				sql.AppendLine("      ,[Typename]");
				sql.AppendLine("  FROM [bookType]");
				sql.AppendLine("where ");
				sql.AppendFormat(" TypeID ='{0}'", TypeID);
				sql.AppendLine("");
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				sdr = cmd.ExecuteReader(CommandBehavior.CloseConnection);

			}
			catch (Exception ex)
			{

				message = string.Format("错误信息{0}", ex.Message);
			}

			return sdr;
		}
		public int UpdatePrice(int id, double price, ref string message)
		{
			int result = -1;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("UPDATE [Book]");
				sql.AppendLine(" SET  ");
				sql.AppendFormat(" [price]='{0}'",price);
				sql.AppendLine(" where ");
				sql.AppendFormat(" id ='{0}'",id);
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				result = cmd.ExecuteNonQuery();
			}
			catch (Exception ex)
			{
				message = string.Format("错误信息{0}", ex.Message);

			}
			finally
			{
				cnn.Close();
			}
			return result;
		}
		public int Delete(int id,ref string message)
		{
			int result = -1;
			SqlConnection cnn = new SqlConnection();
			try
			{
				cnn.ConnectionString = CONNSTR;
				cnn.Open();
				sql.Clear();
				sql.AppendLine("Delete from [Book]");
				sql.AppendLine(" where ");
				sql.AppendFormat(" id ='{0}'", id);
				SqlCommand cmd = new SqlCommand(sql.ToString(), cnn);
				cmd.CommandType = CommandType.Text;
				result = cmd.ExecuteNonQuery();
			}
			catch (Exception ex)
			{
				message = string.Format("错误信息{0}", ex.Message);

			}
			finally
			{
				cnn.Close();
			}
			return result;
		}
	}
}
