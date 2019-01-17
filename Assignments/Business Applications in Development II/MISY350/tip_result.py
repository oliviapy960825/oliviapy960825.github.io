
meal_price=int(raw_input("Enter Total Amount: "))
tip_rate=float(raw_input("Enter your tip rate (such as 0.15): "))
total_amount=meal_price+meal_price*tip_rate
print ("You should pay: $"+str(total_amount))
