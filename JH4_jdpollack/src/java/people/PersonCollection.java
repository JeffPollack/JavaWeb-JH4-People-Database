package people;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
/**
 *
 * @author Jeff
 */
public class PersonCollection {
    
    private ArrayList<Person> pArr = new ArrayList<>();
    String errorMessage = "";
    
    public int size(){
        return pArr.size();
    }
    public Person getPerson(int index){
        return pArr.get(index);
    }
    public String getErrorMessage(){
        return errorMessage;
    }
    
    public static PersonCollection update(PageContext pageContext){
        HttpSession session = pageContext.getSession();
        PersonCollection pCol = (PersonCollection) session.getAttribute("PersonCollection");
        
        if(pCol==null){
            pCol = new PersonCollection();
            session.setAttribute("PersonCollection", pCol);
        }
        
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String action = request.getParameter("action");
        if(action != null){
            
            String name = request.getParameter("name");
            String eyeColor = request.getParameter("eyeColor");
            String hairColor = request.getParameter("hairColor");
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");
            String wepOfChoice = request.getParameter("wepOfChoice");
            
            Person person = new Person(name, eyeColor, hairColor, height, weight, wepOfChoice);
            
            if("Clear List".equals(action)){
                pCol.pArr.clear();
            }else if("add".equals(action)){
                boolean found = false;
                for(int i=0; i < pCol.pArr.size(); i++){
                    if(person.equals(pCol.pArr.get(i))){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    pCol.pArr.add(person);
                    pCol.errorMessage = "";
                }else{
                    pCol.errorMessage = "That person is already on the list";
                }
            }else if("remove".equals(action)){
                for(int i=0; i < pCol.pArr.size(); i++){
                    if(person.equals(pCol.pArr.get(i))){
                        pCol.pArr.remove(i);
                    }
                }
            }else if("update".equals(action)){
                String sIndex = request.getParameter("index");
                int index = Integer.parseInt(sIndex);
                Person p = pCol.pArr.get(index);
                p.setName(name);
                p.setEyeColor(eyeColor);
                p.setHairColor(hairColor);
                p.setHeight(height);
                p.setWeight(weight);
                p.setWepOfChoice(wepOfChoice);
            }
        }       
        return pCol;
    }
}
