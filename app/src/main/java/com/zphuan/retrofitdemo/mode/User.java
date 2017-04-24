package com.zphuan.retrofitdemo.mode;

/**
 * Created by zhongpeihuan on 2017/4/22.
 */

public class User {

    /**
     * login : test
     * id : 383316
     * avatar_url : https://avatars0.githubusercontent.com/u/383316?v=3
     * gravatar_id :
     * url : https://api.github.com/users/test
     * html_url : https://github.com/test
     * followers_url : https://api.github.com/users/test/followers
     * following_url : https://api.github.com/users/test/following{/other_user}
     * gists_url : https://api.github.com/users/test/gists{/gist_id}
     * starred_url : https://api.github.com/users/test/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/test/subscriptions
     * organizations_url : https://api.github.com/users/test/orgs
     * repos_url : https://api.github.com/users/test/repos
     * events_url : https://api.github.com/users/test/events{/privacy}
     * received_events_url : https://api.github.com/users/test/received_events
     * type : User
     * site_admin : false
     * name : null
     * company : null
     * blog : null
     * location : null
     * email : null
     * hireable : null
     * bio : null
     * public_repos : 5
     * public_gists : 0
     * followers : 14
     * following : 0
     * created_at : 2010-09-01T10:39:12Z
     * updated_at : 2014-07-05T07:34:22Z
     */
    public String login;
    public int id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
    public Object name;
    public Object company;
    public Object blog;
    public Object location;
    public Object email;
    public Object hireable;
    public Object bio;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name=" + name +
                ", company=" + company +
                ", blog=" + blog +
                ", location=" + location +
                ", email=" + email +
                ", hireable=" + hireable +
                ", bio=" + bio +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
