using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace 图书管理
{
	class Program
	{
		static void Main(string[] args)
		{
			Manage objM = new Manage();
			objM.ShowMenu();
			Console.ReadLine();

		}
	}
}
