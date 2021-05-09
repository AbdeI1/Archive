def minCost(cj, jc, pattern):
    return pattern.replace("?", "").count("CJ") * cj + pattern.replace("?","").count("JC") * jc


print(minCost(2, 3, "j???c???c?jcj"))