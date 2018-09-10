package com.mingfeichn.thinkinginjava.annotations;

/**
 * 用以创建数据库表的Bean
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastNanme;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNanme() {
        return lastNanme;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
