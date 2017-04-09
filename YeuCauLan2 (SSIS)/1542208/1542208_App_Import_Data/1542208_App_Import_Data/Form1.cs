using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _1542208_App_Import_Data
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnBrowseFilePackage_Click(object sender, EventArgs e)
        {
            try
            {
                OpenFileDialog open = new OpenFileDialog();
                open.Title = "Chọn file package";
                open.Filter = "Dtsx Files|*.dtsx";
                if (open.ShowDialog() == DialogResult.OK)
                {
                    txtFilePackage.Text = open.FileName;
                }
            }
            catch (Exception)
            {
                throw new ApplicationException("Failed loading package file");
            }
        }

        private void btnBrowseFileImport_Click(object sender, EventArgs e)
        {
            try
            {
                OpenFileDialog open = new OpenFileDialog();
                open.Title = "Chọn file txt";
                open.Filter = "Txt Files|*.txt";
                if (open.ShowDialog() == DialogResult.OK)
                {
                    txtFileImport.Text = open.FileName;
                }
            }
            catch (Exception)
            {
                throw new ApplicationException("Failed loading import file");
            }
        }

        private void btnImport_Click(object sender, EventArgs e)
        {
            string filePathPackage = txtFilePackage.Text;
            string filePathImport = txtFileImport.Text;

            if(filePathPackage == "")
            {
                MessageBox.Show(
                                "Can't empty file package", 
                                "Error", 
                                MessageBoxButtons.OK, 
		                        MessageBoxIcon.Error
                           );
                return;
            }

            if(filePathImport == "")
            {
                MessageBox.Show(
                                "Can't empty file import", 
                                "Error", 
                                MessageBoxButtons.OK, 
		                        MessageBoxIcon.Error
                           );
                return;
            }

            btnImport.Enabled = false;

            System.Diagnostics.Process process = new System.Diagnostics.Process();
            System.Diagnostics.ProcessStartInfo startInfo = new System.Diagnostics.ProcessStartInfo();
            startInfo.WindowStyle = System.Diagnostics.ProcessWindowStyle.Hidden;
            startInfo.FileName = "cmd.exe";
            string strCmd = string.Format("/C dtexec -f {0} /set \\package.variables[file_path_import];{1} ", filePathPackage, filePathImport);
            startInfo.Arguments = strCmd;
            process.StartInfo = startInfo;
            process.Start();

            MessageBox.Show(
                                "Import Success", 
                                "Import information", 
                                MessageBoxButtons.OK, 
		                        MessageBoxIcon.Information
                           );
            btnImport.Enabled = true;
        }
    }
}
