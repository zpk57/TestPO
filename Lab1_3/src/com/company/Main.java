package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

//Чтоб одну стеклянную неволю
//Разменять на тысячу других
class Ford
{
//    boolean isSleep = false;
//    boolean isRefusedToSleep = false;
//    boolean isDressedInRobe = false;
//    boolean isUsingComputerNow = false;

    int tryToSleepCount = 0;

    //stateOfFord
    enum currentState {SLEEP, REFUSE_TO_SLEEP, COMUTER_WORK, CREATE_ARTICLE, REFUSE_TO_CREATE_ARTICLE, GOTO_BRIDGE, WEAR_ROBE, NOTHING};

    currentState currentWorkInst = currentState.NOTHING;

    void tryToSleep()
    {
        if((currentWorkInst == currentState.NOTHING)) {
            tryToSleepCount++;

            if (tryToSleepCount >= 1) {
                currentWorkInst = currentState.REFUSE_TO_SLEEP;
            }
        }
        else {
            throw new IllegalStateException("can not try to sleep");
        }

        //TODO: check location
    }

    void UseComputer(Computer ComputerInstance){
        if(currentWorkInst == currentState.REFUSE_TO_SLEEP)
        {
            if(ComputerInstance.isSmall) {
                currentWorkInst = currentState.COMUTER_WORK;
            }else {
                throw new IllegalStateException("illegal computer parameters");
            }
        } else {
            throw new IllegalStateException("can not use computer");
        }
    }

    void TryToCreateArticle(Article ArticleInst)
    {
        if(currentWorkInst == currentState.COMUTER_WORK){
            if(ArticleInst.articleIsCrated) {
                throw new IllegalStateException("article is already created");
            }else {
                if(ArticleInst.isSarcasticAndCutting && ArticleInst.nameOfMagazine.equals("PUTEVODITEL")) {
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
        if(currentWorkInst == currentState.CREATE_ARTICLE){
            if(ArticleInst.articleIsCrated) {
                throw new IllegalStateException("article is already created");
            }else {
                if(ArticleInst.isSarcasticAndCutting && ArticleInst.nameOfMagazine.equals("PUTEVODITEL")) {
                    currentWorkInst = currentState.REFUSE_TO_CREATE_ARTICLE;
                }else {
                    throw new IllegalStateException("illegal article parameters");
                }
            }
        }else {
            throw new IllegalStateException("can not refuse to create article");
        }
    }

    void dress (Robe RobeInst) //robe ?= халат ?
    {
        if(currentWorkInst == currentState.REFUSE_TO_CREATE_ARTICLE) {
            currentWorkInst = currentState.WEAR_ROBE;
        }else {
            throw new IllegalStateException("already wear robe");
        }
    }

    void GoToBridge()
    {
        if(currentWorkInst == currentState.WEAR_ROBE) {
            currentWorkInst = currentState.GOTO_BRIDGE;
        } else {
            throw new IllegalStateException("can not go to bridge");
        }
    }
}

class Robe
{

}

class  Article
{
    public boolean articleIsCrated = false;
    public boolean isSarcasticAndCutting = true; //edkaia
    String nameOfMagazine = "PUTEVODITEL";
}

class Computer
{
    public boolean isSmall = true;

    boolean isStandOn;

    void StandOn()
    {
        if(isSmall) {
            isStandOn = true;
        } else {
            throw new IllegalStateException("computer is not small");
        }
    }
}