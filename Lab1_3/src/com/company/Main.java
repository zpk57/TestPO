package com.company;

public class Main {

    public static void main(String[] args) {
        Ford FordInst = new Ford();
        Article ArticleInst = new Article(true);
        Computer ComputerInst = new Computer(true, Location.location.CABIN_CORNER);
        try {
            ComputerInst.StandOn();
            FordInst.tryToSleep();
            FordInst.UseComputer(ComputerInst);
            FordInst.TryToCreateArticle(ArticleInst);
            FordInst.RefuseCreateArticle(ArticleInst);
            FordInst.DressRobe();
            FordInst.GoToBridge();
        } catch (IllegalStateException e)
        {
            System.out.println("not passed" + e.getMessage());
        }

    }
}

//Чтоб одну стеклянную неволю
//Разменять на тысячу других
class Ford
{
    Location.location fordLocation = Location.location.CABIN_NOT_CORNER;

    int tryToSleepCount = 0;

    //stateOfFord
    enum currentState {SLEEP, REFUSE_TO_SLEEP, COMUTER_WORK, CREATE_ARTICLE, REFUSE_TO_CREATE_ARTICLE, GOTO_BRIDGE, WEAR_ROBE, NOTHING};

    currentState currentWorkInst = currentState.NOTHING;

    void tryToSleep()
    {
        if((currentWorkInst != currentState.REFUSE_TO_SLEEP)) {
            if(fordLocation != Location.location.BRIDGE) {
                tryToSleepCount++;

                if (tryToSleepCount >= 1) {
                    currentWorkInst = currentState.REFUSE_TO_SLEEP;
                }
            }else {
                throw new IllegalStateException("can not try to sleep");
            }
        }
        else {
            throw new IllegalStateException("can not try to sleep");
        }
    }

    void UseComputer(Computer ComputerInstance){
        if(currentWorkInst == currentState.REFUSE_TO_SLEEP)
        {
            if(fordLocation != Location.location.BRIDGE) {
                if (ComputerInstance.isSmall && ComputerInstance.currLocation == Location.location.CABIN_CORNER) {
                    currentWorkInst = currentState.COMUTER_WORK;
                    fordLocation = ComputerInstance.currLocation;
                } else {
                    throw new IllegalStateException("illegal computer parameters");
                }
            }else {
                throw new IllegalStateException("can not use computer");
            }
        } else {
            throw new IllegalStateException("can not use computer");
        }
    }

    void TryToCreateArticle(Article ArticleInst)
    {
        if(currentWorkInst == currentState.COMUTER_WORK && fordLocation == Location.location.CABIN_CORNER){
            if(ArticleInst.articleIsCrated) {
                throw new IllegalStateException("article is already created");
            }else {
                if(ArticleInst.isSarcasticAndCutting && ArticleInst.aboutWagons && ArticleInst.nameOfMagazine.equals("PUTEVODITEL")) {
                    currentWorkInst = currentState.CREATE_ARTICLE;
                }else {
                    throw new IllegalStateException("illegal article parameters");
                }
            }
        }else {
            throw new IllegalStateException("can not try to create article");
        }
    }

    void RefuseCreateArticle(Article ArticleInst)
    {
        if(currentWorkInst == currentState.CREATE_ARTICLE && fordLocation == Location.location.CABIN_CORNER){
            if(ArticleInst.articleIsCrated) {
                throw new IllegalStateException("article is already created");
            }else {
                if(ArticleInst.isSarcasticAndCutting && ArticleInst.aboutWagons && ArticleInst.nameOfMagazine.equals("PUTEVODITEL")) {
                    currentWorkInst = currentState.REFUSE_TO_CREATE_ARTICLE;
                }else {
                    throw new IllegalStateException("illegal article parameters");
                }
            }
        }else {
            throw new IllegalStateException("can not refuse to create article");
        }
    }

    void DressRobe () //robe ?= халат ?
    {
        if(currentWorkInst == currentState.REFUSE_TO_CREATE_ARTICLE &&
                (fordLocation == Location.location.CABIN_CORNER || fordLocation == Location.location.CABIN_NOT_CORNER)) {
            currentWorkInst = currentState.WEAR_ROBE;
        }else {
            throw new IllegalStateException("can not dress robe");
        }
    }

    void GoToBridge()
    {
        if(currentWorkInst == currentState.WEAR_ROBE && fordLocation != Location.location.BRIDGE) {
            currentWorkInst = currentState.GOTO_BRIDGE;
        } else {
            throw new IllegalStateException("can not go to bridge");
        }
    }
}

class Location
{
    enum location {CABIN_NOT_CORNER, CABIN_CORNER, BRIDGE};
}

class  Article
{
    public boolean articleIsCrated = false;
    public boolean isSarcasticAndCutting = true; //edkaia
    public boolean aboutWagons;
    String nameOfMagazine = "PUTEVODITEL";
    Article(boolean aboutWagons) {
        this.aboutWagons = aboutWagons;
    }
}

class Computer
{
    Location.location currLocation;

    public boolean isSmall;

    boolean isStandOn;

    Computer(boolean isSmall, Location.location currLocation)
    {
        this.isSmall = isSmall;
        this.currLocation = currLocation;
    }
    void StandOn()
    {
        if(isSmall) {
            if(currLocation == Location.location.CABIN_CORNER) {
                isStandOn = true;
            }else {
                throw new IllegalStateException("computer is not in corner of cabin");
            }
        } else {
            throw new IllegalStateException("computer is not small");
        }
    }
}