package controller;

import service.ArquivoTexto;

public class OutputController
{

    private ArquivoTexto file;

    private boolean useConsole;

    private static OutputController ourInstance = new OutputController();

    public static OutputController getInstance() {
        return ourInstance;
    }

    private OutputController() {
        this.file = null;
        this.useConsole = true;
    }

    public boolean useControle()
    {
        return useConsole;
    }

    public void initFile(String name)
    {
        this.file = new ArquivoTexto(name);
        this.useConsole = false;
    }

    public void close()
    {
        if (this.file == null || useConsole) {
            return;
        }
        this.file.closeFile();
        this.file = null;
        this.useConsole = true;
    }

    public void print(String txt)
    {
        print(txt, true);
    }

    public void print(String txt, boolean breakLine)
    {
        if (this.file == null || useConsole) {
            if (breakLine) {
                System.out.println(txt);
            } else {
                System.out.print(txt);
            }
            return;
        }

        if (breakLine) {
            this.file.appendTextWithNewLine(txt);
        } else {
            this.file.appendText(txt);
        }
    }

}
