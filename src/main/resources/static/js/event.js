/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<script type = "text/javascript">
        function setMaxDay(){
            var month = document.getElementsByName(month);
            if (month == 2){
                document.write(Day: < input type="number" name="day" min="1" max="28"/>);
            } else if (month % 2 != 0){
                document.write(Day: < input type="number" name="day" min="1" max="31"/>);
            } else {
                document.write(Day: < input type="number" name="day" min="1" max="30"/>);
            }
        }
</script>

