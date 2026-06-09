<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>የተጠቃሚ መረጃ</title>
    <link rel="stylesheet" href="Form.css">
</head>
<body>

<div class="container">

    <div class="form-card">

        <h2>1. የተጠቃሚው መረጃ</h2>

        <form action="success.jsp" method="post">

            <input type="text" placeholder="ሙሉ ስም" required>

            <div class="row">
                <input type="text" placeholder="ክልል" required>
                <input type="text" placeholder="ዞን" required>
            </div>

            <div class="row">
                <input type="text" placeholder="ወረዳ" required>
                <input type="text" placeholder="ቀበሌ" required>
            </div>

            <input type="number" placeholder="እድሜ" required>

            <select name="gender" required>
            <option value="">ጾታ</option>
            <option>ወንድ</option>
            <option>ሴት</option>
        </select>

            <input type="text" placeholder="ዜግነት" required>
            <p>የትውልድ ዘመን</p><br>
            <input type="date" placeholder="የትውልድ ዘመን" required>

            <input type="text" placeholder="የስራ አይነት" required>
              <p>ፎርም የተሞላበት ቀን</p><br>
            <input type="date" required>

            <h2>2. የቅርብ ተጠሪ ወይም ተያዥ</h2>

            <input type="text" placeholder="ሙሉ ስም" required>
       <select name="gender" required>
            <option value="">ጾታ</option>
            <option>ወንድ</option>
            <option>ሴት</option>
        </select>
            <div class="row">
                <input type="text" placeholder="ክልል" required>
                <input type="text" placeholder="ዞን" required>
            </div>

            <div class="row">
                <input type="text" placeholder="ወረዳ" required>
                <input type="text" placeholder="ቀበሌ" required>
            </div>

            <input type="text" placeholder="ዜግነት" required>

            <input type="text" placeholder="ስልክ ቁጥር" required>

            <button type="submit">አስገባ</button>

        </form>

    </div>

</div>

</body>
</html>