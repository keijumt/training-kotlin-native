//
//  ViewController.swift
//  ios
//
//  Created by 松本圭樹 on 2018/11/09.
//  Copyright © 2018年 keijumt. All rights reserved.
//

import UIKit
import common

class ViewController: UIViewController, GithubView {

    @IBOutlet weak var sampleLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let presenter = GithubPresenterImpl(view: self, githubRepository: GithubRepositoryImpl(githubApi: GithubApi()))
        presenter.fetchUser(userId: "keijumt")
    }
    
    func showUser(user: User) {
        sampleLabel.text = user.name
    }
}

