using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 图书管理
{
	class Book
	{
		int id;

		public int Id
		{
			get { return id; }
			set { id = value; }
		}
		string name;

		public string Name
		{
			get { return name; }
			set { name = value; }
		}
		int typeId;

		public int TypeId
		{
			get { return typeId; }
			set { typeId = value; }
		}
		int number;

		public int Number
		{
			get { return number; }
			set { number = value; }
		}
		double price;

		public double Price
		{
			get { return price; }
			set { price = value; }
		}
	}
}
