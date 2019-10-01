from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
import  selenium
import time

def login(br, user_name, pass_word):
    br.get("http://eventsforall.000webhostapp.com/")
    username = br.find_element_by_name("username")
    username.send_keys(user_name)
    password = br.find_element_by_name("password")
    password.send_keys(pass_word)
    password.send_keys(Keys.RETURN)
    time.sleep(5)
def start(user_name, pass_word):
        br = webdriver.Chrome()

    #try:
        login(br, user_name, pass_word)
    #except :
        #print("wrong details.try again")
        #login(br, user_name, pass_word)
    #try:
        br.get("http://eventsforall.000webhostapp.com/list.php")
        event_link = br.find_element_by_name("addeventlink")
        event_link.click()
        br.get("http://eventsforall.000webhostapp.com/addevent.html")
        name = br.find_element_by_name("organisername")
        name.send_keys("aaa")

        event_name = br.find_element_by_name("eventname")
        event_name.send_keys("aaaa")

        date = br.find_element_by_name("date")
        date.clear()
        date.send_keys('09/05/2019')

        address = br.find_element_by_name(" address")
        address.send_keys('address bitch!!!!!')

        city= br.find_element_by_name("city")
        city.send_keys("puneeeeeeeeeee")

        state = br.find_element_by_name("state")
        state.send_keys("goa")

        country = br.find_element_by_name("country")
        country.send_keys("india")

        pcode = br.find_element_by_name("postalcode")
        pcode.send_keys("545452")

        contact = br.find_element_by_name("contact")
        contact.send_keys("6855266558")

        email = br.find_element_by_name("email")
        email.send_keys("ashjkjk")

        submit = br.find_element_by_name("addevent")
        submit.click()

        time.sleep(5)


    #except:
        #print("wrong details.try again")

        #(br, user_name, pass_word)


        time.sleep(5)
        br.close()

#username = input()
#pasword = input()
start("dummy@gmail.com", "dummy")
#dummy@gmail.com
#dumm