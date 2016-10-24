package dk.rxajavaretrofit.entity;

import java.util.List;

/**
 * Created by dk on 2016/10/24.
 */

public class Movie {

    /**
     * rating : {"max":10,"average":9.6,"stars":"50","min":0}
     * genres : ["犯罪","剧情"]
     * title : 肖申克的救赎
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg"},"name":"鲍勃·冈顿","id":"1041179"}]
     * collect_count : 972586
     * original_title : The Shawshank Redemption
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"},"name":"弗兰克·德拉邦特","id":"1047973"}]
     * year : 1994
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg"}
     * alt : https://movie.douban.com/subject/1292052/
     * id : 1292052
     */

    private List<SubjectsBean> subjects;

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        private String title;
        private String original_title;
        private String year;
        /**
         * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg
         * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg
         * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg
         */

        private ImagesBean images;
        private String alt;
        private List<String> genres;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public static class ImagesBean {
            private String large;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }
    }
}
