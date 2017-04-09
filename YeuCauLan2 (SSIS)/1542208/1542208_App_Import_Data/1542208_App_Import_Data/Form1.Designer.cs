namespace _1542208_App_Import_Data
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.txtFilePackage = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnBrowseFilePackage = new System.Windows.Forms.Button();
            this.txtFileImport = new System.Windows.Forms.TextBox();
            this.btnBrowseFileImport = new System.Windows.Forms.Button();
            this.btnImport = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(26, 23);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(103, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "File Package (.dtsx):";
            // 
            // txtFilePackage
            // 
            this.txtFilePackage.Location = new System.Drawing.Point(135, 20);
            this.txtFilePackage.Name = "txtFilePackage";
            this.txtFilePackage.ReadOnly = true;
            this.txtFilePackage.Size = new System.Drawing.Size(331, 20);
            this.txtFilePackage.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(26, 59);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(81, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "File Import (.txt):";
            // 
            // btnBrowseFilePackage
            // 
            this.btnBrowseFilePackage.Location = new System.Drawing.Point(472, 18);
            this.btnBrowseFilePackage.Name = "btnBrowseFilePackage";
            this.btnBrowseFilePackage.Size = new System.Drawing.Size(75, 23);
            this.btnBrowseFilePackage.TabIndex = 3;
            this.btnBrowseFilePackage.Text = "Browse";
            this.btnBrowseFilePackage.UseVisualStyleBackColor = true;
            this.btnBrowseFilePackage.Click += new System.EventHandler(this.btnBrowseFilePackage_Click);
            // 
            // txtFileImport
            // 
            this.txtFileImport.Location = new System.Drawing.Point(135, 56);
            this.txtFileImport.Name = "txtFileImport";
            this.txtFileImport.ReadOnly = true;
            this.txtFileImport.Size = new System.Drawing.Size(331, 20);
            this.txtFileImport.TabIndex = 4;
            // 
            // btnBrowseFileImport
            // 
            this.btnBrowseFileImport.Location = new System.Drawing.Point(472, 53);
            this.btnBrowseFileImport.Name = "btnBrowseFileImport";
            this.btnBrowseFileImport.Size = new System.Drawing.Size(75, 23);
            this.btnBrowseFileImport.TabIndex = 5;
            this.btnBrowseFileImport.Text = "Browse";
            this.btnBrowseFileImport.UseVisualStyleBackColor = true;
            this.btnBrowseFileImport.Click += new System.EventHandler(this.btnBrowseFileImport_Click);
            // 
            // btnImport
            // 
            this.btnImport.Location = new System.Drawing.Point(236, 92);
            this.btnImport.Name = "btnImport";
            this.btnImport.Size = new System.Drawing.Size(104, 23);
            this.btnImport.TabIndex = 6;
            this.btnImport.Text = "Import Data";
            this.btnImport.UseVisualStyleBackColor = true;
            this.btnImport.Click += new System.EventHandler(this.btnImport_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(559, 130);
            this.Controls.Add(this.btnImport);
            this.Controls.Add(this.btnBrowseFileImport);
            this.Controls.Add(this.txtFileImport);
            this.Controls.Add(this.btnBrowseFilePackage);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtFilePackage);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtFilePackage;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnBrowseFilePackage;
        private System.Windows.Forms.TextBox txtFileImport;
        private System.Windows.Forms.Button btnBrowseFileImport;
        private System.Windows.Forms.Button btnImport;
    }
}

