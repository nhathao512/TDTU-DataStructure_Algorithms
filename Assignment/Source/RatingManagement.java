import java.io.*;
import java.util.*;

public class RatingManagement 
{
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    public static void SortString(ArrayList<String> lstring) 
    {
        for (int i = 0; i < lstring.size() - 1; i++) 
        {
            int mi1n1 = i;
            for (int j = i+1; j < lstring.size(); j++) 
            {
                if (lstring.get(j).compareTo(lstring.get(mi1n1)) < 0)
                {
                    mi1n1 = j;
                }
            }
            String t1 = lstring.get(mi1n1);
            lstring.set(mi1n1, lstring.get(i));
            lstring.set(i, t1);
        }
    }

    public static void SortMovie(ArrayList<Movie> lmov)
    {
        for (int h = 0; h < lmov.size() - 1; h++) 
        {
            int mi2n2 = h;
            for (int k = h+1; k < lmov.size(); k++) 
            {
                if (lmov.get(k).getName().compareToIgnoreCase(lmov.get(mi2n2).getName()) < 0) 
                {
                    mi2n2 = k;
                }
            }
            Movie t2 = lmov.get(mi2n2);
            lmov.set(mi2n2, lmov.get(h));
            lmov.set(h, t2);
        }
    }

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) 
    {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) 
    {
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        try 
        {
            File f1 = new File(ratingPath);
            Scanner sc1 = new Scanner(f1);

            if (sc1.hasNextLine()) 
            {
                sc1.nextLine();
            }

            while (sc1.hasNextLine()) 
            {
                String l1 = sc1.nextLine();
                String[] p1 = l1.split(",");
                int UserID = Integer.parseInt(p1[0]);
                int MovieID = Integer.parseInt(p1[1]);
                int Rating = Integer.parseInt(p1[2]);
                long Timestamp = Long.parseLong(p1[3]);
                Rating rate = new Rating(UserID, MovieID, Rating, Timestamp);
                ratings.add(rate);
            }
            sc1.close();
        }
        catch (IOException exception) 
        {
            exception.printStackTrace();
        }
        return ratings; 
    }

    private ArrayList<Movie> loadMovies(String moviePath) 
    {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try 
        {
            File f1 = new File(moviePath);
            Scanner sc1 = new Scanner(f1);

            if (sc1.hasNextLine()) 
            {
                sc1.nextLine();
            }

            while (sc1.hasNextLine()) 
            {
                String l1 = sc1.nextLine();
                String[] p1 = l1.split(",");
                int MovieID = Integer.parseInt(p1[0]);
                String Title = p1[1];
                ArrayList<String> Genres = new ArrayList<String>(Arrays.asList(p1[2].split("-")));
                Movie movie = new Movie(MovieID, Title, Genres);
                movies.add(movie);
            }
            sc1.close();
        }
        catch (IOException exception) 
        {
            exception.printStackTrace();
        }
        return movies; 
    }

    private ArrayList<User> loadUsers(String userPath) 
    {
        ArrayList<User> users = new ArrayList<User>();
        try 
        {
            File f1 = new File(userPath);
            Scanner sc1 = new Scanner(f1);

            if (sc1.hasNextLine()) 
            {
                sc1.nextLine();
            }
            
            while (sc1.hasNextLine()) 
            {
                String l1 = sc1.nextLine();
                String[] p1 = l1.split(",");
                int UserID = Integer.parseInt(p1[0]);
                String Gender = p1[1];
                int Age = Integer.parseInt(p1[2]);
                String Occupation = p1[3];
                String Zipcode = p1[4];
                User user = new User(UserID, Gender, Age, Occupation, Zipcode);
                users.add(user);
            }
            sc1.close();
        }
        catch (IOException exception) 
        {
            exception.printStackTrace();
        }
        return users; 
    }

    public ArrayList<Movie> getMovies() 
    {
        return movies;
    }

    public ArrayList<User> getUsers() 
    {
        return users;
    }

    public ArrayList<Rating> getRating() 
    {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) 
    {
        ArrayList<Movie> yc2 = new ArrayList<Movie>();
        for (Rating ra : ratings)
        {
            if ((ra.getUserId() == userId) && (ra.getRating() >= rating ))
            {
                for (Movie mo : movies)
                {
                    if (mo.getId() == ra.getMovieId())
                    {
                        yc2.add(mo);
                    }
                }
            }
        }
        SortMovie(yc2);
        return yc2; 
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) 
    {
        ArrayList<User> yc3 = new ArrayList<User>();
        int rate = 0;
        for (Rating r1a : ratings)
        {
            if ((r1a.getUserId() == userId) && (r1a.getMovieId() == movieId ))
            {
                rate = r1a.getRating();
            }
        }
        for (Rating r2a : ratings)
        {
            if ((r2a.getMovieId() == movieId) && (r2a.getRating() == rate))
            {
                for (User us : users)
                {
                    if ((us.getId() == r2a.getUserId()) && (r2a.getUserId() != userId))
                    {
                        yc3.add(us);
                    }
                }
            } 
        }
        return yc3; 
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() 
    {
        ArrayList<String> yc4 = new ArrayList<>();
        HashMap<Integer, Integer> luuyc4 = new HashMap<>();

        for (Rating ra : ratings) 
        {
            if (ra.getRating() > 3) 
            {
                Integer de1m1 = luuyc4.getOrDefault(ra.getMovieId(), 0);
                if (de1m1 == null)
                {
                    luuyc4.put(ra.getMovieId(), 1);
                }
                else
                {
                    luuyc4.put(ra.getMovieId(), de1m1 + 1);
                }  
            }
        }
        for (Movie mo : movies) 
        {
            Integer de2m2 = luuyc4.getOrDefault(mo.getId(), 0);
            if (de2m2 >= 2) 
            {
                yc4.add(mo.getName());
            }
        }
        SortString(yc4);
        return yc4;
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) 
    {
        ArrayList<String> yc5 = new ArrayList<>();
        HashSet<String> kt = new HashSet<>();

        for (User us : users) 
        {
            if (us.getOccupation().equals(occupation) && us.getGender().equals(gender)) 
            {
                for (Rating ra : ratings) 
                {
                    if (ra.getUserId() == us.getId() && ra.getRating() == rating) 
                    {
                        for (Movie mo : movies) 
                        {
                            if ((ra.getMovieId() == mo.getId()) && (kt.add(mo.getName())))
                            {
                                yc5.add(mo.getName());
                                break;
                            }
                        }
                    }
                }
            }
        }
        SortString(yc5);
        if (yc5.size() < k) 
        {
            return yc5; 
        }
        else 
        {
            ArrayList<String> yc5lon = new ArrayList<>(yc5.subList(0, k));
            return yc5lon;
        }
    }
    
    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) 
    {
        ArrayList<String> yc6 = new ArrayList<>();
        HashSet<String> kt = new HashSet<>();

        for (User us : users) 
        {
            if (us.getOccupation().equals(occupation)) 
            {
                for (Rating ra : ratings) 
                {
                    if (ra.getUserId() == us.getId() && ra.getRating() < rating) 
                    {
                        for (Movie mo : movies) 
                        {
                            if ((ra.getMovieId() == mo.getId()) && (kt.add(mo.getName())))
                            {
                                yc6.add(mo.getName());
                                break;
                            }
                        }
                    }
                }
            }
        }
        SortString(yc6);
        if (yc6.size() < k) 
        {
            return yc6; 
        }
        else 
        {
            ArrayList<String> yc6lon = new ArrayList<>(yc6.subList(0, k));
            return yc6lon;
        }
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) 
    {
        ArrayList<String> yc7 = new ArrayList<>();
        int idgan = -1;
        Rating dggan = null;

        for (Rating r1a : ratings) 
        {
            if (r1a.getUserId() == userId && r1a.getRating() >= rating) 
            {
                if (dggan == null || dggan.getTimestamps() < r1a.getTimestamps()) 
                {
                    dggan = r1a;
                }
            }
        }
    
        idgan = dggan.getMovieId();
    
        for (Movie mo : movies) 
        {
            if (mo.getId() != idgan) 
            {
                boolean chung = false;
                for (String ge : mo.getGenres()) 
                {
                    for (Movie mgan : movies) 
                    {
                        if (mgan.getId() == idgan && mgan.getGenres().contains(ge)) 
                        {
                            for (Rating r2a : ratings) 
                            {
                                if (r2a.getMovieId() == mo.getId() && r2a.getRating() >= rating) 
                                {
                                    yc7.add(mo.getName());
                                    break;
                                }
                            }
                            chung = true;
                            break;
                        }
                    }
                    if (chung) 
                    {
                        break;
                    }
                }
            }
        }
    
        SortString(yc7);
        
        if (yc7.size() < k) 
        {
            return yc7; 
        }
        else 
        {
            ArrayList<String> yc7lon = new ArrayList<>(yc7.subList(0, k));
            return yc7lon; 
        }
    }
    
}