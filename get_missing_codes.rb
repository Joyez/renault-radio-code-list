require 'net/http'

def get_code code
  uri = URI('http://www.physmo.com/renault/calc.php')
  res = Net::HTTP.post_form(uri, 'incode' => code)
  p res.body
  res.body.match(/Your radio unlock code is: <p>(\d{4})</)[1]
end

known = File.readlines('README.md')[5..-1].map do |line|
  line.split('|')[1,2].map(&:strip)
end

precodes = ('A'..'Z').map do |letter|
  ('000'..'999').map do |number|
    "#{ letter }#{ number }"
  end
end.flatten

File.open('results.md', 'w') do |f|
  precodes.each do |precode|
    known_code = known.find { |k, v| k == precode }
    code = known_code ? known_code[1] : get_code(precode)
    f.puts "| #{ precode } | #{ code } |"
    puts "found code"
    p precode, code
  end
end

