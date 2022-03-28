package objectsAndClassesExercise;

import java.util.*;

public class P04Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            articles.add(new Article(title, content, author));
        }

        String command = scanner.nextLine();

        switch (command) {
            case "title":
                articles.sort((a,b) -> b.getTitle().compareTo(a.getTitle()));
//                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort((a,b) -> b.getContent().compareTo(a.getContent()));
//                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort((a,b) -> b.getAuthor().compareTo(a.getAuthor()));
//                articles.sort(Comparator.comparing(Article::getAuthor));
                break;
        }
        for (Article article : articles) {
            System.out.println(article.toString());
        }
    }

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
}


//        List<Article> articleList=new LinkedList<>();
//        int n=Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            String [] articleToken=scanner.nextLine().split(", ");
//            String title=articleToken[0];
//            String content=articleToken[1];
//            String author=articleToken[2];
//            Article article=new Article(title,content,author);
//            if(!articleList.contains(article)){
//                articleList.add(article);
//            }
//        }
//        String filter=scanner.nextLine();
//        switch (filter){
//            case "content":
//                Collections.sort(articleList, new Comparator<Article>() {
//                    @Override
//                    public int compare(Article o1, Article o2) {
//                        return o2.content.compareTo(o1.content);
//                    }
//                });
//                break;
//            case "title":
//                Collections.sort(articleList, new Comparator<Article>() {
//                    @Override
//                    public int compare(Article o1, Article o2) {
//                        return o2.title.compareTo(o1.title);
//                    }
//                });
//                break;
//            case "author":
//                Collections
//                        .sort(articleList, new Comparator<Article>() {
//                    @Override
//                    public int compare(Article o1, Article o2) {
//                        return o2.author.compareTo(o1.author);
//                    }
//                });
//                break;
//        }
//        for (Article article : articleList) {
//            System.out.println(article);
//        }
//    }
//    static class Article{
//        String title;
//        String content;
//        String author;
//
//        public Article(String title, String content, String author) {
//            this.title = title;
//            this.content = content;
//            this.author = author;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%s - %s: %s",this.title,this.content,this.author);
//        }
//    }
//}