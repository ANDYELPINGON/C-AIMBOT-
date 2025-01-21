

Mem memory = new Mem();
public Mem MemLib = new Mem();












if (Process.GetProcessesByName("HD-Player").Length == 0)
    {
        // guna2HtmlLabel20.Text = "Abrir emulador...";
        Console.Beep(2000, 400);

    }
    else
    {
       // label1.Visible = true;
        // loading.Start();
        Int32 proc = Process.GetProcessesByName("HD-Player")[0].Id;
        memory.OpenProcess(proc);

        var result = await memory.AoBScan("? ? FF FF 00 00 00 00 00 00 00 00 00 00 00 00 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 A5 43 00 00 00 00 ? ? ? ? 00 00 00 00 00 00 00 00 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 ? ? ? ? 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 80 ?", true, true);
        if (result.Any())
        {
            foreach (var Current in result)
            {
                Int64 leitura = Current + 0x90;
                Int64 escri = Current + 0x52;
                var Read = memory.ReadMemory<int>(leitura.ToString("X"));
                memory.WriteMemory(escri.ToString("X"), "int", Read.ToString());

            }
          //  guna2HtmlLabel20.Text = "Aimbot safe : Activated";
            Console.Beep(600, 300);
           // label1.Visible = false;
            // loading.Stop();
            f2Pressed = false;
        }
        else
        {
           // label1.Visible = false;
            // loading.Stop();
           // guna2HtmlLabel20.Text = "Aimbot safe : Activated..2";
        }
    }
}
