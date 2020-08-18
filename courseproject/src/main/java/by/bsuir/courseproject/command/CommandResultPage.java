package by.bsuir.courseproject.command;

public class CommandResultPage {
    private String page;
    private boolean forward = true;

    public CommandResultPage(){}
    public CommandResultPage(String page, boolean forward) {
        this.page = page;
        this.forward = forward;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public CommandResultPage(String page) {
        this.page = page;
    }

//    public static CommandResultPage forward(String page){
//        return new CommandResultPage(page, true);
//    }
//
//    public static CommandResultPage redirect (String page){
//        return new CommandResultPage(page, false);
//    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public String getPage() {
        return page;
    }

    public boolean isForward() {
        return forward;
    }
}
